const jsforce = require('jsforce');

// ppb credential
const username = 'soumya.kolluri@harmonicinc.com.hlitppb';
const password = 'Forsys@1234';

const sandboxConn = new jsforce.Connection({
	loginUrl: 'https://harmonic--hlitppb.sandbox.my.salesforce.com',
});

// declaring two arguments (parameters)
const startDate = process.argv[2];
const endDate = process.argv[3];

console.log('startDate:', startDate);
console.log('endDate:', endDate);
// any logic that is applicable to dev console
const cancellation = `
List<Apttus_Billing__UsageInput__c> usageinputList = [select Id,Apttus_Billing__Description__c,
Apttus_Billing__Status__c, Apttus_Billing__Quantity__c, Apttus_Billing__StartDate__c,
Apttus_Billing__EndDate__c, LastModifiedDate, LastModifiedBy.Name from
Apttus_Billing__UsageInput__c where Apttus_Billing__Quantity__c >0 and Apttus_Billing__StartDate__c
>= ${startDate} and Apttus_Billing__EndDate__c <= ${endDate} and Apttus_Billing__Status__c ='Rated'
and APTS_B_Usage_Status__c ='Completed'];
Set<Id> uiIdSet = new Set<Id>();
if(usageinputList!=null){
for(Apttus_Billing__UsageInput__c ui:usageinputList){
uiIdSet.add(ui.id);
}
}

Apttus_Billing.BillingService.processRatedUsageInput(uiIdSet);

List<Apttus_Billing__UsageInput__c> unratedusageList = [select
Id,Apttus_Billing__Message__c,Apttus_Billing__Description__c, Apttus_Billing__Status__c,
Apttus_Billing__Quantity__c, Apttus_Billing__StartDate__c, Apttus_Billing__EndDate__c,
LastModifiedDate, LastModifiedBy.Name from Apttus_Billing__UsageInput__c where
Apttus_Billing__Quantity__c >0 and Apttus_Billing__StartDate__c >= ${startDate} and
Apttus_Billing__EndDate__c <= ${endDate} and Apttus_Billing__Status__c ='Error' and
APTS_B_Usage_Status__c ='Completed'];
List<Apttus_Billing__UsageInput__c> tobeRated = new List<Apttus_Billing__UsageInput__c>();
if(unratedusageList!=null){
for(Apttus_Billing__UsageInput__c ui : unratedusageList){
ui.Apttus_Billing__Status__c = 'Loaded';
ui.Apttus_Billing__Message__c = '';
tobeRated.add(ui);
}
update tobeRated;
}
`;

async function main() {
	// login to sandbox
	await sandboxConn.login(username, password);
	// execute the annouymous apex similar to dev console
	const result = await sandboxConn.tooling.executeAnonymous(cancellation);
	console.log('Cancel result:', result);
}

main().catch((err) => {
	console.error(err);
	process.exit(1);
});
