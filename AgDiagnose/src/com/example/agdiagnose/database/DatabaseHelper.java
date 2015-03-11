package com.example.agdiagnose.database;



import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.example.agdiagnose.*;





public class DatabaseHelper {

	
	//Animals column names
	public static final String KEY_ANIMALS_ID = "id_animals";
	public static final String KEY_ANIMALS_TYPE = "type_animals";
	//Diseases column names
	public static final String KEY_DISEASES_ID = "_id";
	public static final String KEY_DISEASES_NAME = "name_diseases";
	public static final String KEY_DISEASES_DESCRIPTION = "description_diseases";
	public static final String KEY_DISEASES_IMAGE = "image_diseases";
	//Animals_Diseases column names
	public static final String KEY_Animals_Diseases_ID = "id_animals_diseases";
	public static final String KEY_ANIMAL = "animals_id";
	public static final String KEY_DISEASE = "diseases_id";
	//Vet column names
	public static final String KEY_VET_ID = "id_vet";
	public static final String TITLE = "name_vet";
	public static final String SNIPPET = "vet_phone";
	public static final String POSITION = "latlng";
	//Category column names
	public static final String KEY_CATEGORY_ID = "id_category";
	public static final String KEY_CATEGORY_TYPE = "type_category";
	//Animal category diseases
	public static final String KEY_ANI_CAT_DIS = "id_ani_cat_dis";
	public static final String KEY_ANI = "id_ani";
	public static final String KEY_CAT = "id_cat";
	public static final String KEY_DIS = "id_dis";
	//Tables
	public static final String TABLE_VET = "Vet";
	private static final String TABLE_ANIMALS = "Animals";
	private static final String TABLE_DISEASES = "Diseases";
	private static final String TABLE_ANIMALS_DISEASES = "Animals_Diseases";
	private static final String TABLE_CATEGORY = "Category";
	private static final String TABLE_ANI_CAT_DIS = "Ani_cat_dis";
	
	private static final int DATABASE_VERSION =1;
	private static final String DATABASE_NAME = "AgDiagnoseDatabase.db";
	
	
	 DBHelper ourHelper;
	 Context ourContext;
	 SQLiteDatabase ourDatabase;
	 
	
	private static class DBHelper extends SQLiteOpenHelper{
		
		//Create Tables 
		//Create Animals table
		public static final String CREATE_TABLE_ANIMALS = "CREATE TABLE "+ TABLE_ANIMALS  
				+"(" +KEY_ANIMALS_ID + " INTEGER PRIMARY KEY, "+
				KEY_ANIMALS_TYPE + " VARCHAR(20)" + ")";
		
		//Create Diseases table
		public static final String CREATE_TABLE_DISEASES = "CREATE TABLE " + TABLE_DISEASES
		            + "(" + KEY_DISEASES_ID + " INTEGER PRIMARY KEY," + KEY_DISEASES_NAME + " VARCHAR,"
		            + KEY_DISEASES_DESCRIPTION + " VARCHAR," +KEY_DISEASES_IMAGE+  " VARCHAR" + ")";	
		
		//Create Animals_Diseases table  
		public static final String CREATE_TABLE_ANIMALS_DISEASES = "CREATE TABLE "
	            + TABLE_ANIMALS_DISEASES + "(" + KEY_Animals_Diseases_ID + " INTEGER PRIMARY KEY,"
	            + KEY_ANIMAL + " INTEGER," + KEY_DISEASE + " INTEGER" +")";
		
		
		//Create Vet Table 
		public static final String CREATE_TABLE_VET = "CREATE TABLE " + TABLE_VET  
					+ "(" + KEY_VET_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," 
		            + TITLE + " VARCHAR,"
	                + SNIPPET +  " VARCHAR," 
		            + POSITION + " VARCHAR" + ")";	
		
		//Create Category Table
				public static final String CREATE_TABLE_CATEGORY = "CREATE TABLE "+ TABLE_CATEGORY  
						+"(" +KEY_CATEGORY_ID + " INTEGER PRIMARY KEY, "+
						KEY_CATEGORY_TYPE + " VARCHAR" + ")";
				
				//Create Ani_cat_dis Table
				public static final String CREATE_TABLE_ANI_CAT_DIS = "CREATE TABLE "
			            + TABLE_ANI_CAT_DIS + "(" + KEY_ANI_CAT_DIS + " INTEGER PRIMARY KEY,"
			            + KEY_ANI + " INTEGER," + KEY_CAT + " INTEGER," + KEY_DIS + " INTEGER" +")";
		
        
		public DBHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			 db.execSQL(CREATE_TABLE_ANIMALS);
		     db.execSQL(CREATE_TABLE_DISEASES);
		     db.execSQL(CREATE_TABLE_ANIMALS_DISEASES);
		     db.execSQL(CREATE_TABLE_VET);
		     db.execSQL(CREATE_TABLE_CATEGORY);
		     db.execSQL(CREATE_TABLE_ANI_CAT_DIS);
		     
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_ANIMALS);
	        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DISEASES);
	        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ANIMALS_DISEASES);
	        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VET);
			
		
	        onCreate(db);
		}
	}	
	
	public DatabaseHelper(Context c){
		ourContext = c;
	}
	

	public DatabaseHelper open(){
		ourHelper = new DBHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;
	}
	
	public void close(){
		ourHelper.close();
	}
	
	
	/***************************** INSERT ANIMALS **************************************/
	public void insertAnimals(){
		ContentValues cv = new ContentValues();
		cv.put(KEY_ANIMALS_ID, "1");
		cv.put(KEY_ANIMALS_TYPE, "Cow");
		ourDatabase.insert(TABLE_ANIMALS, null, cv);
		
		cv.put(KEY_ANIMALS_ID, "2");
		cv.put(KEY_ANIMALS_TYPE, "Sheep");
		ourDatabase.insert(TABLE_ANIMALS, null, cv);
		
		cv.put(KEY_ANIMALS_ID, "3");
		cv.put(KEY_ANIMALS_TYPE, "Calf");
		ourDatabase.insert(TABLE_ANIMALS, null, cv);
		
		cv.put(KEY_ANIMALS_ID, "4");
		cv.put(KEY_ANIMALS_TYPE, "Lamb");
		ourDatabase.insert(TABLE_ANIMALS, null, cv);
	}

	/***************************** INSERT DISEASES **************************************************/
		
	public void insertDiseases(){
		ContentValues cv = new ContentValues();
		cv.put(KEY_DISEASES_ID, "1");
		cv.put(KEY_DISEASES_NAME, "Bluetongue");
		cv.put(KEY_DISEASES_DESCRIPTION, "Respiratory disease");
		cv.put(KEY_DISEASES_IMAGE, "image");
		ourDatabase.insert(TABLE_DISEASES, null, cv);
		
		cv.put(KEY_DISEASES_ID, "2");
		cv.put(KEY_DISEASES_NAME, "Foot Rot");
		cv.put(KEY_DISEASES_DESCRIPTION, "Skin Eyes and Feet disease");
		cv.put(KEY_DISEASES_IMAGE, "image");
		ourDatabase.insert(TABLE_DISEASES, null, cv);
		
		cv.put(KEY_DISEASES_ID, "3");
		cv.put(KEY_DISEASES_NAME, "Calf Diphtheria");
		cv.put(KEY_DISEASES_DESCRIPTION, "disease");
		cv.put(KEY_DISEASES_IMAGE, "image");
		ourDatabase.insert(TABLE_DISEASES, null, cv);
		
		cv.put(KEY_DISEASES_ID, "4");
		cv.put(KEY_DISEASES_NAME, "TB");
		cv.put(KEY_DISEASES_DESCRIPTION, "Respiratory disease");
		cv.put(KEY_DISEASES_IMAGE, "image");
		ourDatabase.insert(TABLE_DISEASES, null, cv);
		
		cv.put(KEY_DISEASES_ID, "5");
		cv.put(KEY_DISEASES_NAME, "BVD");
		cv.put(KEY_DISEASES_DESCRIPTION, "Respiratory disease");
		cv.put(KEY_DISEASES_IMAGE, "image");
		ourDatabase.insert(TABLE_DISEASES, null, cv);
		
		cv.put(KEY_DISEASES_ID, "6");
		cv.put(KEY_DISEASES_NAME, "Abortion");
		cv.put(KEY_DISEASES_DESCRIPTION, "Reproductive disease");
		cv.put(KEY_DISEASES_IMAGE, "image");
		ourDatabase.insert(TABLE_DISEASES, null, cv);
		
		cv.put(KEY_DISEASES_ID, "7");
		cv.put(KEY_DISEASES_NAME, "Cystic Ovaries");
		cv.put(KEY_DISEASES_DESCRIPTION, "Reproductive disease");
		cv.put(KEY_DISEASES_IMAGE, "image");
		ourDatabase.insert(TABLE_DISEASES, null, cv);
		
		cv.put(KEY_DISEASES_ID, "8");
		cv.put(KEY_DISEASES_NAME, "Foot and Mouth");
		cv.put(KEY_DISEASES_DESCRIPTION, "Skin Eyes Feet disease");
		cv.put(KEY_DISEASES_IMAGE, "image");
		ourDatabase.insert(TABLE_DISEASES, null, cv);
		
		cv.put(KEY_DISEASES_ID, "9");
		cv.put(KEY_DISEASES_NAME, "Ringworm");
		cv.put(KEY_DISEASES_DESCRIPTION, "Skin Eyes Feet disease");
		cv.put(KEY_DISEASES_IMAGE, "image");
		ourDatabase.insert(TABLE_DISEASES, null, cv);
		
		cv.put(KEY_DISEASES_ID, "10");
		cv.put(KEY_DISEASES_NAME, "Johnes");
		cv.put(KEY_DISEASES_DESCRIPTION, "Viruses and bacteria");
		cv.put(KEY_DISEASES_IMAGE, "image");
		ourDatabase.insert(TABLE_DISEASES, null, cv);
		
		cv.put(KEY_DISEASES_ID, "11");
		cv.put(KEY_DISEASES_NAME, "Liver Fluke");
		cv.put(KEY_DISEASES_DESCRIPTION, "Viruses and bacteria");
		cv.put(KEY_DISEASES_IMAGE, "image");
		ourDatabase.insert(TABLE_DISEASES, null, cv);
		
		
	}																																															

	/***************************** INSERT ANIMALS **************************************/
	
	public void insertAnimalsDiseases(){
		ContentValues cv = new ContentValues();
		cv.put(KEY_Animals_Diseases_ID, "1");
		cv.put(KEY_ANIMAL, "1");
		cv.put(KEY_DISEASE, "1");
		ourDatabase.insert(TABLE_ANIMALS_DISEASES, null, cv);
		
		cv.put(KEY_Animals_Diseases_ID, "2");
		cv.put(KEY_ANIMAL, "2");
		cv.put(KEY_DISEASE, "1");
		ourDatabase.insert(TABLE_ANIMALS_DISEASES, null, cv);
		
		cv.put(KEY_Animals_Diseases_ID, "3");
		cv.put(KEY_ANIMAL, "1");
		cv.put(KEY_DISEASE, "2");
		ourDatabase.insert(TABLE_ANIMALS_DISEASES, null, cv);
		
		cv.put(KEY_Animals_Diseases_ID, "4");
		cv.put(KEY_ANIMAL, "2");
		cv.put(KEY_DISEASE, "2");
		ourDatabase.insert(TABLE_ANIMALS_DISEASES, null, cv);
		
		cv.put(KEY_Animals_Diseases_ID, "5");
		cv.put(KEY_ANIMAL, "3");
		cv.put(KEY_DISEASE, "3");
		ourDatabase.insert(TABLE_ANIMALS_DISEASES, null, cv);
		
		
	}
	
	/*************************** INSERT CATEGORIES ***********************************************************/
	public void insertCategory(){
		ContentValues cv = new ContentValues();
		cv.put(KEY_CATEGORY_ID, "1");
		cv.put(KEY_CATEGORY_TYPE, "Respiratory");
		ourDatabase.insert(TABLE_CATEGORY, null, cv);
		
		cv.put(KEY_CATEGORY_ID, "2");
		cv.put(KEY_CATEGORY_TYPE, "Skin Eyes Feet");
		ourDatabase.insert(TABLE_CATEGORY, null, cv);

		cv.put(KEY_CATEGORY_ID, "3");
		cv.put(KEY_CATEGORY_TYPE, "Viruses Bacteria");
		ourDatabase.insert(TABLE_CATEGORY, null, cv);
		
		cv.put(KEY_CATEGORY_ID, "4");
		cv.put(KEY_CATEGORY_TYPE, "Reproductive");
		ourDatabase.insert(TABLE_CATEGORY, null, cv);
	}
	

/*************************** INSERT ANI_CAT_DIS ***********************************************************/
	
	public void insertAnimalsCategoryDiseases(){
		ContentValues cv = new ContentValues();
		cv.put(KEY_ANI_CAT_DIS, "1");
		cv.put(KEY_ANI, "1");
		cv.put(KEY_CAT, "1");
		cv.put(KEY_DIS, "1");
		ourDatabase.insert(TABLE_ANI_CAT_DIS, null, cv);
		
		cv.put(KEY_ANI_CAT_DIS, "2");
		cv.put(KEY_ANI, "1");
		cv.put(KEY_CAT, "1");
		cv.put(KEY_DIS, "4");
		ourDatabase.insert(TABLE_ANI_CAT_DIS, null, cv);
		
		cv.put(KEY_ANI_CAT_DIS, "3");
		cv.put(KEY_ANI, "1");
		cv.put(KEY_CAT, "1");
		cv.put(KEY_DIS, "5");
		ourDatabase.insert(TABLE_ANI_CAT_DIS, null, cv);

		cv.put(KEY_ANI_CAT_DIS, "4");
		cv.put(KEY_ANI, "1");
		cv.put(KEY_CAT, "2");
		cv.put(KEY_DIS, "8");
		ourDatabase.insert(TABLE_ANI_CAT_DIS, null, cv);
		
		cv.put(KEY_ANI_CAT_DIS, "5");
		cv.put(KEY_ANI, "1");
		cv.put(KEY_CAT, "2");
		cv.put(KEY_DIS, "9");
		ourDatabase.insert(TABLE_ANI_CAT_DIS, null, cv);
		
		cv.put(KEY_ANI_CAT_DIS, "6");
		cv.put(KEY_ANI, "1");
		cv.put(KEY_CAT, "3");
		cv.put(KEY_DIS, "10");
		ourDatabase.insert(TABLE_ANI_CAT_DIS, null, cv);
		
		cv.put(KEY_ANI_CAT_DIS, "7");
		cv.put(KEY_ANI, "1");
		cv.put(KEY_CAT, "3");
		cv.put(KEY_DIS, "11");
		ourDatabase.insert(TABLE_ANI_CAT_DIS, null, cv);
		
		cv.put(KEY_ANI_CAT_DIS, "8");
		cv.put(KEY_ANI, "1");
		cv.put(KEY_CAT, "4");
		cv.put(KEY_DIS, "5");
		ourDatabase.insert(TABLE_ANI_CAT_DIS, null, cv);
		
		cv.put(KEY_ANI_CAT_DIS, "9");
		cv.put(KEY_ANI, "1");
		cv.put(KEY_CAT, "4");
		cv.put(KEY_DIS, "6");
		ourDatabase.insert(TABLE_ANI_CAT_DIS, null, cv);
		
		cv.put(KEY_ANI_CAT_DIS, "10");
		cv.put(KEY_ANI, "1");
		cv.put(KEY_CAT, "4");
		cv.put(KEY_DIS, "7");
		ourDatabase.insert(TABLE_ANI_CAT_DIS, null, cv);
	}

	/*************************** GET ANIMALS ***********************************************************/
	
	/*************************** GET ALL COWS ***********************************/
	
	public String getCowDiseases() {
		
		 Cursor c = ourDatabase.rawQuery("SELECT name_diseases " +
		 		"FROM Animals, Diseases " +
		 		"INNER JOIN Animals_Diseases " +
		 		"ON Animals_Diseases.animals_id = Animals.id_animals " +
		 		"AND Animals_Diseases.diseases_id = Diseases.id_diseases " +
		 		"WHERE type_animals = ?", new String[]{"Cow"});
		 		String result = "";
			
			int iName = c.getColumnIndex("name_diseases");
			for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				//result = result + c.getString(iRow) + " " + c.getString(iName) + " " + c.getString(iDesc) + " " + c.getString(iImage) + " \n";
				result = result + c.getString(iName) + " \n"; 
			}
			return result;
		
			
		}
	
	/*************************** GET RESPIRTORY COWS ***********************************/
	
	public Cursor getCowRespiratoryDiseases(){
		Cursor c = ourDatabase.rawQuery("SELECT _id, name_diseases " +
				"FROM Animals, Diseases, Category " +
				"INNER JOIN Ani_Cat_Dis " + 
				"ON Ani_Cat_Dis.id_ani = Animals.id_animals AND Ani_Cat_Dis.id_cat = Category.id_category AND Ani_Cat_Dis.id_dis = Diseases._id  " +
				"WHERE type_animals = 'Cow' AND type_category = ?", new String[]{"Respiratory"});
 
		if(c.moveToFirst()){
			do{
			DiseaseObj disease = new DiseaseObj();
			disease.set_id(Integer.parseInt(c.getString(0)));
			disease.setName_diseases(c.getString(1));
			//disease.setDescription_diseases(c.getString(2));
			//disease.setImage_diseases(c.getBlob(3));
		}while(c.moveToNext());
		
		}
	return c;
		
}		
	
	

	public Cursor getCowSkinDiseases(){
		Cursor c = ourDatabase.rawQuery("SELECT _id, name_diseases " +
				"FROM Animals, Diseases, Category " +
				"INNER JOIN Ani_Cat_Dis " + 
				"ON Ani_Cat_Dis.id_ani = Animals.id_animals AND Ani_Cat_Dis.id_cat = Category.id_category AND Ani_Cat_Dis.id_dis = Diseases._id  " +
				"WHERE type_animals = 'Cow' AND type_category = ?", new String[]{"Skin Eyes Feet"});
	//	String result = "";
	//	int iName = c.getColumnIndex("name_diseases");
	//	for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
	//		result = result + c.getString(iName) + " \n"; 
			

		if(c.moveToFirst()){
			do{
			DiseaseObj disease = new DiseaseObj();
			disease.set_id(Integer.parseInt(c.getString(0)));
			disease.setName_diseases(c.getString(1));
			//disease.setDescription_diseases(c.getString(2));
			//disease.setImage_diseases(c.getBlob(3));
		}while(c.moveToNext());
		
		}
	return c;
		
}		
	
	public Cursor getCowVirDiseases(){
		Cursor c = ourDatabase.rawQuery("SELECT _id, name_diseases " +
				"FROM Animals, Diseases, Category " +
				"INNER JOIN Ani_Cat_Dis " + 
				"ON Ani_Cat_Dis.id_ani = Animals.id_animals AND Ani_Cat_Dis.id_cat = Category.id_category AND Ani_Cat_Dis.id_dis = Diseases._id  " +
				"WHERE type_animals = 'Cow' AND type_category = ?", new String[]{"Viruses Bacteria"});
		if(c.moveToFirst()){
			do{
			DiseaseObj disease = new DiseaseObj();
			disease.set_id(Integer.parseInt(c.getString(0)));
			disease.setName_diseases(c.getString(1));
			//disease.setDescription_diseases(c.getString(2));
			//disease.setImage_diseases(c.getBlob(3));
		}while(c.moveToNext());
		
		}
	return c;
	}
	
	public Cursor getCowReproductiveDiseases(){
		Cursor c = ourDatabase.rawQuery("SELECT _id, name_diseases " +
				"FROM Animals, Diseases, Category " +
				"INNER JOIN Ani_Cat_Dis " + 
				"ON Ani_Cat_Dis.id_ani = Animals.id_animals AND Ani_Cat_Dis.id_cat = Category.id_category AND Ani_Cat_Dis.id_dis = Diseases._id  " +
				"WHERE type_animals = 'Cow' AND type_category = ?", new String[]{"Reproductive"});
		if(c.moveToFirst()){
			do{
			DiseaseObj disease = new DiseaseObj();
			disease.set_id(Integer.parseInt(c.getString(0)));
			disease.setName_diseases(c.getString(1));
			//disease.setDescription_diseases(c.getString(2));
			//disease.setImage_diseases(c.getBlob(3));
		}while(c.moveToNext());
		
		}
	return c;
	}
	
	
	
	/*************************** SHEEP ***********************************/
	
	public String getSheepDiseases(){
		 Cursor c = ourDatabase.rawQuery("SELECT name_diseases " +
			 		"FROM Animals, Diseases " +
			 		"INNER JOIN Animals_Diseases " +
			 		"ON Animals_Diseases.animals_id = Animals.id_animals " +
			 		"AND Animals_Diseases.diseases_id = Diseases.id_diseases " +
			 		"WHERE type_animals = ?", new String[]{"Sheep"});
			 String result = "";
				int iRow = c.getColumnIndex(KEY_DISEASES_ID);
				int iName = c.getColumnIndex("name_diseases");
				int iDesc = c.getColumnIndex(KEY_DISEASES_DESCRIPTION);
				int iImage = c.getColumnIndex(KEY_DISEASES_IMAGE);
				for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
					//result = result + c.getString(iRow) + " " + c.getString(iName) + " " + c.getString(iDesc) + " " + c.getString(iImage) + " \n";
					result = result + c.getString(iName) + " \n"; 
				}
				return result;
		
		
	}
	
	
	/*************************** CALVES ***********************************/
	
	public String getCalfDiseases(){
		Cursor c = ourDatabase.rawQuery("SELECT name_diseases " +
		 		"FROM Animals, Diseases " +
		 		"INNER JOIN Animals_Diseases " +
		 		"ON Animals_Diseases.animals_id = Animals.id_animals " +
		 		"AND Animals_Diseases.diseases_id = Diseases.id_diseases " +
		 		"WHERE type_animals = ?", new String[]{"Calf"});
		 String result = "";
			int iRow = c.getColumnIndex(KEY_DISEASES_ID);
			int iName = c.getColumnIndex("name_diseases");
			int iDesc = c.getColumnIndex(KEY_DISEASES_DESCRIPTION);
			int iImage = c.getColumnIndex(KEY_DISEASES_IMAGE);
			for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				//result = result + c.getString(iRow) + " " + c.getString(iName) + " " + c.getString(iDesc) + " " + c.getString(iImage) + " \n";
				result = result + c.getString(iName) + " \n"; 
			}
			return result;
		
	}
	
	/*************************** LAMBS ***********************************/

	public String getLambDiseases(){
		Cursor c = ourDatabase.rawQuery("SELECT name_diseases " +
		 		"FROM Animals, Diseases " +
		 		"INNER JOIN Animals_Diseases " +
		 		"ON Animals_Diseases.animals_id = Animals.id_animals " +
		 		"AND Animals_Diseases.diseases_id = Diseases.id_diseases " +
		 		"WHERE type_animals = ?", new String[]{"Lamb"});
		 String result = "";
			int iRow = c.getColumnIndex(KEY_DISEASES_ID);
			int iName = c.getColumnIndex("name_diseases");
			int iDesc = c.getColumnIndex(KEY_DISEASES_DESCRIPTION);
			int iImage = c.getColumnIndex(KEY_DISEASES_IMAGE);
			for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				//result = result + c.getString(iRow) + " " + c.getString(iName) + " " + c.getString(iDesc) + " " + c.getString(iImage) + " \n";
				result = result + c.getString(iName) + " \n"; 
			}
			return result;
		
	}
	
	
	
	
	
	
	/***************************** Get disease description  ********************************************/
	
	public String getDescriptionDisease(long diseaseID){
		
		Cursor c = ourDatabase.rawQuery("SELECT " + KEY_DISEASES_DESCRIPTION+ " FROM " +TABLE_DISEASES+ " WHERE " + DatabaseHelper.KEY_DISEASES_ID + "  = " +diseaseID ,null);
		String result = "";
		int idescription = c.getColumnIndex(KEY_DISEASES_DESCRIPTION);
				for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
					result = result + c.getString(idescription); 
					
				}
				
				return result;
		
		
	}
	
	
	/************************** MARKERS ****************************************************************/
	
	/************************** ADD MARKERS ******************************************/
	
	public void addMarker(MyMarkerObj m) {
		ContentValues cv = new ContentValues();
		//cv.put(DatabaseHelper.KEY_VET_ID, m.getId_vet());
		cv.put(DatabaseHelper.TITLE, m.getTitle());
		cv.put(DatabaseHelper.SNIPPET, m.getSnippet());
		cv.put(DatabaseHelper.POSITION, m.getPosition());
		ourDatabase.insert(DatabaseHelper.TABLE_VET, null, cv);
		
	}
	
	/************************** GET MARKERS ******************************************/
	
	
	String[] cols = {DatabaseHelper.TITLE, DatabaseHelper.SNIPPET, DatabaseHelper.POSITION};
	
	public List<MyMarkerObj> getMyMarkers()
	{
		List<MyMarkerObj> markers = new ArrayList<MyMarkerObj>(); 
		Cursor cursor = ourDatabase.query(DatabaseHelper.TABLE_VET, cols, null, null, null, null, null);
		cursor.moveToFirst();
		while(!cursor.isAfterLast()){
			MyMarkerObj m = cursorToMarker(cursor);
			markers.add(m);
			cursor.moveToNext();
			
			
			
		}
		cursor.close();
		return markers;
		
		
	}	
	
	/************************** CURSOR TO MARKER ******************************************/
	
	private MyMarkerObj cursorToMarker (Cursor cursor){
		MyMarkerObj m = new MyMarkerObj();
		m.setTitle(cursor.getString(0));
		m.setSnippet(cursor.getString(1));
		m.setPosition(cursor.getString(2));
		
		
		
		return m;		
		
	}
	
	
	
	}