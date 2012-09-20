package vinova.project.PetroManager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PetroHelper extends SQLiteOpenHelper{
	public class CostPetro {
		public static final String ID= "Id_";
		public static final String TABLE_NAME= "CostPetro";
		public static final String DATE = "Date";
		public static final String MONEY = "Money";
		public static final String CONGTOMET= "CongToMet";
	}

	public class Fixing {
		public static final String ID = "_Id";
		public static final String TABLE_NAME = "Fixing";
		public static final String DATE = "Date";
		public static final String PLACE_FIXING = "PlaceFixing";
		public static final String OPINION = "Opinion";		
	}
	public class Fixing_Detail{
		public static final String ID= "Id";
		public static final String TABLE_NAME ="FixingDetail";
		public static final String FIXING_ID= "FixingId";
		public static final String REASON = "Reason";
		public static final String MONEY= "Money";
	}	
	private static final String DATABASE_NAME = "petroDatabase";
	private static final int DATABASE_VERSION = 1;
	
	public PetroHelper(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE "+ CostPetro.TABLE_NAME+" ("
			       +CostPetro.ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"
				   +CostPetro.DATE+" TEXT,"				   
				   +CostPetro.CONGTOMET+" TEXT,"							  				   			    
			       +CostPetro.MONEY +" TEXT);");
		db.execSQL("CREATE TABLE "+ Fixing.TABLE_NAME+" ("
			       +Fixing.ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"
				   +Fixing.DATE+" TEXT,"				   
				   +Fixing.PLACE_FIXING+" TEXT,"							  				   			    
			       +Fixing.OPINION +" TEXT);");
		db.execSQL("CREATE TABLE "+ Fixing_Detail.TABLE_NAME+" ("
			       +Fixing_Detail.ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"
				   +Fixing_Detail.REASON+" TEXT,"				   
				   +Fixing_Detail.MONEY+" TEXT,"							  				   			    
			       +Fixing_Detail.FIXING_ID +" TEXT);");
		 
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS"+CostPetro.TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS"+Fixing_Detail.TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS"+Fixing.TABLE_NAME);
	}
	
	public long addCostPetro(String date,String money,String Congtomet){
		ContentValues cv = new ContentValues();
		cv.put(CostPetro.DATE, date);
		cv.put(CostPetro.MONEY,money);
		cv.put(CostPetro.CONGTOMET,Congtomet);
		SQLiteDatabase db= getWritableDatabase();
		return db.insert(CostPetro.TABLE_NAME, CostPetro.ID, cv);
	}
	public long addFixingDetail(String fixingId,String Reason,String Money){
		ContentValues cv = new ContentValues();
		cv.put(Fixing_Detail.MONEY, Money);
		cv.put(Fixing_Detail.REASON, Reason);
		cv.put(Fixing_Detail.FIXING_ID, fixingId);
		SQLiteDatabase db= getWritableDatabase();
		return db.insert(Fixing_Detail.TABLE_NAME, Fixing_Detail.ID, cv);
	}
	public long addFixing(String Date,String Place,String Opinion){
		ContentValues cv = new ContentValues();
		cv.put(Fixing.DATE, Date);
		cv.put(Fixing.PLACE_FIXING, Place);
		cv.put(Fixing.OPINION,Opinion);
		SQLiteDatabase db= getWritableDatabase();
		return db.insert(Fixing.TABLE_NAME, Fixing.ID, cv);
	}

}
