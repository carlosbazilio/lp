// C++ Example of a Low-Quality Routine

void HandleStuff( CORP_DATA & inputRec, int crntQtr, EMP_DATA empRec, double& estimRevenue, double ytdRevenue, int screenX, int screenY, COLOR_TYPE &newColor, COLOR_TYPE & prevColor, StatusType & status, int expenseType ) { 

	int i;

	for ( i = 0; i < 100; i++ )
	{
		inputRec.revenue[i] = 0;
		inputRec.expense[i] = corpExpense[ crntQtr ][ i ];
	} 
	UpdateCorpDatabase( empRec ); 
	estimRevenue = ytdRevenue * 4.0 / (double) crntQtr; 
	newColor = prevColor; 
	status = SUCCESS; 
	if ( expenseType == 1 ) {
		for ( i = 0; i < 12; i++ )
			profit[i] = revenue[i] - expense.type1[i];
		} 
	else if ( expenseType == 2 ) {
			profit[i] = revenue[i] - expense.type2[i];
	} else if ( expenseType == 3 )
		profit[i] = revenue[i] - expense.type3[i];
}

