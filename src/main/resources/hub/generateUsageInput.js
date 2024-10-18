const jsforce = require('jsforce');

const username = process.argv[2];
const password = process.argv[3];
const accountId = process.argv[4];
const billingAccountId = process.argv[5];
const selectedLocation = process.argv[6];
const startDate = new Date(process.argv[7]);
const endDate = new Date(process.argv[8]);
const diffDays = process.argv[9];

const sandboxConn = new jsforce.Connection({
    loginUrl: 'https://test.salesforce.com',
});

console.log('startDate:', startDate);
console.log('endDate:', endDate);

const commonUsageInputApex = `
VosUsageReportController.numberOfDays = ${diffDays};
VosUsageReportController controller = new VosUsageReportController();
controller.selectedAccount = '${accountId}';
controller.selectedReferenceAccount = '${billingAccountId}';
controller.selectedLocation = '${selectedLocation}';
controller.filterbyAccount = true;
controller.specifyBillingSchedule = true;
controller.isStagingTest = true;
controller.specifiedStartDate = Date.newInstance(${startDate.getFullYear()}, ${startDate.getMonth() + 1}, ${startDate.getDate()});
controller.specifiedEndDate = Date.newInstance(${endDate.getFullYear()}, ${endDate.getMonth() + 1}, ${endDate.getDate()});
`;

const deleteUsageInputApex = `
${commonUsageInputApex}
controller.showAccountVosAssets();
List<VosUsageReportController.VosUsageInput> usageInputs = controller.getAccountUsageInputs();
List<String> ids = new List<String>();
for (VosUsageReportController.VosUsageInput input : usageInputs) {
    ids.add(input.recordId);
}
List<Apttus_Billing__UsageInput__c> apttusBillingInputs = [SELECT Id FROM Apttus_Billing__UsageInput__c WHERE Id IN :ids];
delete apttusBillingInputs;
`;

const updateUsageInputApex = `
${commonUsageInputApex}
controller.showAccountLocations();
controller.updateLocationUsageInputs();
`;

const reportServiceMrrUsage = `
Set<String> accountList = new Set<String>();
accountList.add('${accountId}');
Date bsStartDate = Date.newInstance(${startDate.getFullYear()}, ${startDate.getMonth() + 1}, ${startDate.getDate()});
Date bsEndDate = Date.newInstance(${endDate.getFullYear()}, ${endDate.getMonth() + 1}, ${endDate.getDate()});
VosUsageReportController.reportUsgeInputsForVosServiceHourAssets(accountList, bsStartDate, bsEndDate, true);
`;

async function main() {
    console.log(`Running Hub Usage Generation with Account: [${accountId}], Reference Account: [${billingAccountId}], Account Location: [${selectedLocation}]`);

    await sandboxConn.login(username, password);
    let result = await sandboxConn.tooling.executeAnonymous(deleteUsageInputApex);
    console.log('Usage input clean up trigger result:', result);
    result = await sandboxConn.tooling.executeAnonymous(updateUsageInputApex);
    console.log('Usage input generate trigger result:', result);
    result = await sandboxConn.tooling.executeAnonymous(reportServiceMrrUsage);
    console.log('Report service mrr trigger result:', result);
}

main().catch((err) => {
    console.error(err);
    process.exit(1);
});
