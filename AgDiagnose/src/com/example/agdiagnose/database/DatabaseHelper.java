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
	public static final String KEY_DISEASES_SYMPTOMS = "symptoms_diseases";
	public static final String KEY_DISEASES_TREATMENT = "treatment_diseases";
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
	//Reproduction 
	public static final String KEY_REPRODUCTION_ID = "id_reproduction";
	public static final String KEY_REPRODUCTION_BREEDING ="breeding_reproduction";
	public static final String KEY_REPRODUCTION_GESTATION ="gestation_reproduction";
	public static final String KEY_REPRODUCTION_BIRTH ="birth_reproduction";
	public static final String KEY_REPRODUCTION_ANIMAL = "animal_reproduction";
	// Tables
	public static final String TABLE_VET = "Vet";
	private static final String TABLE_ANIMALS = "Animals";
	private static final String TABLE_DISEASES = "Diseases";
	private static final String TABLE_ANIMALS_DISEASES = "Animals_Diseases";
	private static final String TABLE_CATEGORY = "Category";
	private static final String TABLE_ANI_CAT_DIS = "Ani_cat_dis";
	private static final String TABLE_REPRODUCTION = "Reproduction";
	
	private static final int DATABASE_VERSION =1;
	private static final String DATABASE_NAME = "AgDiagnoseDatabase.db";
	
	
	 DBHelper ourHelper;
	 Context ourContext;
	 SQLiteDatabase ourDatabase;
	 
	
	private static class DBHelper extends SQLiteOpenHelper{
		
		//Create Tables 
		//Create Animals table
		public static final String CREATE_TABLE_ANIMALS = "CREATE TABLE "+ TABLE_ANIMALS  
				+"(" +KEY_ANIMALS_ID + " INTEGER PRIMARY KEY,"
				+ KEY_ANIMALS_TYPE + " VARCHAR(20)" + ")";
		
		//Create Diseases table
		public static final String CREATE_TABLE_DISEASES = "CREATE TABLE " + TABLE_DISEASES
		            + "(" + KEY_DISEASES_ID + " INTEGER PRIMARY KEY," 
		            + KEY_DISEASES_NAME + " VARCHAR,"
		            + KEY_DISEASES_DESCRIPTION + " VARCHAR," 
		            + KEY_DISEASES_SYMPTOMS + " VARCHAR," 
		            + KEY_DISEASES_TREATMENT + " VARCHAR," 
		            + KEY_DISEASES_IMAGE+  " VARCHAR" + ")";	
		
		//Create Animals_Diseases table  
		public static final String CREATE_TABLE_ANIMALS_DISEASES = "CREATE TABLE " + TABLE_ANIMALS_DISEASES 
				+ "(" + KEY_Animals_Diseases_ID + " INTEGER PRIMARY KEY,"
	            + KEY_ANIMAL + " INTEGER," 
				+ KEY_DISEASE + " INTEGER" +")";
		
		
		//Create Vet Table 
				public static final String CREATE_TABLE_VET = "CREATE TABLE " + TABLE_VET  
					+ "(" + KEY_VET_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," 
		            + TITLE + " VARCHAR,"
	                + SNIPPET +  " VARCHAR," 
		            + POSITION + " VARCHAR" + ")";	
		
		//Create Category Table
				public static final String CREATE_TABLE_CATEGORY = "CREATE TABLE "+ TABLE_CATEGORY  
						+"(" +KEY_CATEGORY_ID + " INTEGER PRIMARY KEY,"
						+ KEY_CATEGORY_TYPE + " VARCHAR" + ")";
				
		//Create Ani_cat_dis Table
				public static final String CREATE_TABLE_ANI_CAT_DIS = "CREATE TABLE "
			            + TABLE_ANI_CAT_DIS + "(" + KEY_ANI_CAT_DIS + " INTEGER PRIMARY KEY,"
			            + KEY_ANI + " INTEGER," 
			            + KEY_CAT + " INTEGER," 
			            + KEY_DIS + " INTEGER" +")";
				
				//Create Reproduction Table
				public static final String CREATE_TABLE_REPRODUCTION = " CREATE TABLE "
						+ TABLE_REPRODUCTION + "(" + KEY_REPRODUCTION_ID + " INTEGER PRIMARY KEY, "
						+ KEY_REPRODUCTION_BREEDING + " VARCHAR, "
						+ KEY_REPRODUCTION_GESTATION + " VARCHAR, "
						+ KEY_REPRODUCTION_BIRTH + " VARCHAR, "
						+ KEY_REPRODUCTION_ANIMAL + " INTEGER " +")";
		
        
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
		     db.execSQL(CREATE_TABLE_REPRODUCTION);
		     
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
		cv.put(KEY_DISEASES_DESCRIPTION, "Bluetonge is an insect-borne viral disease. It is not contagious but is transferred by insect vectors.");
		cv.put(KEY_DISEASES_SYMPTOMS, "The keys symptoms include fever, excessive salivation and nasel discharge. In acute cases the lips and tongue become swollen. Lameness may also occur.");
		cv.put(KEY_DISEASES_TREATMENT, "There is no efficient treatment. The bluetongue virus does not survive outside the insect vectors. Prevention includes quarantine and movement controls to prevent the spread of the disease.");
		cv.put(KEY_DISEASES_IMAGE, "image");
		ourDatabase.insert(TABLE_DISEASES, null, cv);
		
		cv.put(KEY_DISEASES_ID, "2");
		cv.put(KEY_DISEASES_NAME, "Foot Rot");
		cv.put(KEY_DISEASES_DESCRIPTION, "Foot Rot is a hoof infection which is extremely painful and contagious. It occurs in the area between the two toes of the animal and can spred to the whole herd. It is caused by bacteria (Fusobacterium necrophorum and Bacteroides melaninogenicus) in the soil.");
		cv.put(KEY_DISEASES_SYMPTOMS, "Skin between the claws of the hoof begins to swell, skin between toes are very red and tender, lameness, foul odor from infected foot");
		cv.put(KEY_DISEASES_TREATMENT, "The infected animal should be isolated from others. Clean and trim the foot. Penicillian is commonly used to treat foot rot. The infected animal should be kept dry until healing has occured. If there are no signs of recovery after 4 days, the bacteria could have infected teh other tissues if the foot.");
		cv.put(KEY_DISEASES_IMAGE, "image");
		ourDatabase.insert(TABLE_DISEASES, null, cv);
		
		cv.put(KEY_DISEASES_ID, "3");
		cv.put(KEY_DISEASES_NAME, "Calf Diphtheria");
		cv.put(KEY_DISEASES_DESCRIPTION, "Calf Diphtheria consists of two forms; acute oral infection which affects calves less than 3 months old, the other form which is seen in older calves affects the larynx. Both types are caused by the bacteria Fusobacterium necrophorum. ");
		cv.put(KEY_DISEASES_SYMPTOMS, "Oral form symptoms include; swollen cheek, fould smelling ulceration inside of mouth, high temperature, coughing, loss of appetite, depression, pneumonia. Laryngeal form may have the following symptoms; coughing, high temperature, loss of appetite, difficult breathing and chewing and pneumonia. ");
		cv.put(KEY_DISEASES_TREATMENT, "Antibiotics and painkillers are an effective treatment. Isolate the infected animal from other animals. If animals are closely confined, the spread of this infectious disease can be prevented by thoroughly cleaning and disinfecting of all calf feeders.Young calves must be examined daily to identify early stages of the disease.");
		cv.put(KEY_DISEASES_IMAGE, "image");
		ourDatabase.insert(TABLE_DISEASES, null, cv);
	
		cv.put(KEY_DISEASES_ID, "4");
		cv.put(KEY_DISEASES_NAME, "Bovine Tuberculosis (TB)");
		cv.put(KEY_DISEASES_DESCRIPTION, "Bovine Tuberculosis is caused by the bacterium Mycobacterium bovis. The bacteria can survive in a wide range of acids and alkalis. Bovine tuberculosis is a zoonotic disease and causes tuberculosis in human. The disease can be transmitted in raw milk but pasteurisation effectively prevents the spread via milk.");
		cv.put(KEY_DISEASES_SYMPTOMS, "Bovine tuberculosis usually has a prolonged course, and symptoms take months or years to appear. The following symptoms include weakness, loss of appetite, weight loss, fuctuating fever, cough, diarrhoea and large lymph nodes");
		cv.put(KEY_DISEASES_TREATMENT, "The method of detection is the tuberculin test where a small amounnt of antigen is injected into the skin. The control measure applied is test and slaughter. Treatment of infected animals is rarely attempted because of the high cost, lengthy time and the larger goal of eliminating the disease.");
		cv.put(KEY_DISEASES_IMAGE, "image");
		ourDatabase.insert(TABLE_DISEASES, null, cv);
		
		cv.put(KEY_DISEASES_ID, "5");
		cv.put(KEY_DISEASES_NAME, "Bovine Viral Diarrhoea (BVD)");
		cv.put(KEY_DISEASES_DESCRIPTION, "BVD is a cause of respiratory and reproductive issues within the herd.It is caused by the bovine viral diarrhea virus (BVDV). It is transmitted in numerous ways, through congenital infection of the fetus or after birth. Congenitally infected fetuses that survive in utero infection (i.e., the live-births) may be born as BVDV-infected calves. The BVDV infection in these calves will persist during the entire life of the calf, and they will shed BVDV continuously in the farm environment.");
		cv.put(KEY_DISEASES_SYMPTOMS, "Symptoms of acute infection include fever, lethargy, loss of appetite, ocular dishcharge, nasal dischargem oral lesions, diarrhea and decreasing milk production. In calves, the most commonly recognised birth defect is cerebellar hypoplasia, symptoms include; ataxia, tremors, wide stance, stumbling, failure to nurse. ");
		cv.put(KEY_DISEASES_TREATMENT, "The treatment is very limited. Infected  animals should be culled. However vaccines are available.");
		cv.put(KEY_DISEASES_IMAGE, "image");
		ourDatabase.insert(TABLE_DISEASES, null, cv);
		
		cv.put(KEY_DISEASES_ID, "6");
		cv.put(KEY_DISEASES_NAME, "Abortion");
		cv.put(KEY_DISEASES_DESCRIPTION, "Cows and sheep can suffer abnormalities during pregnancy. In all cases where the pregnancy terminates early and the foetus dies as a result are called abortions. There are numerous causes of abortion including drug induced, stress, high fever, nutritional, twin pregnancy and genetic. ");
		cv.put(KEY_DISEASES_SYMPTOMS, "Animal weak, depressed and early termination of pregnancy.");
		cv.put(KEY_DISEASES_TREATMENT, "If the cause of abortion is infectious, antibiotics are prescribed for the animal. The infected animal should be isolated from other animals. More information; http://www.merckmanuals.com/vet/reproductive_system/abortion_in_large_animals/overview_of_abortion_in_large_animals.html ");
		cv.put(KEY_DISEASES_IMAGE, "image");
		ourDatabase.insert(TABLE_DISEASES, null, cv);
		
		cv.put(KEY_DISEASES_ID, "7");
		cv.put(KEY_DISEASES_NAME, "Cystic Ovaries");
		cv.put(KEY_DISEASES_DESCRIPTION, "Cyctic ovarian disease usually occurs in the first two months after calving/lambing. Follicular cysts result from failure of ovulation and luteinization.  ");
		cv.put(KEY_DISEASES_SYMPTOMS, "Abnormal estrous behavior pattern and failure to cycle");
		cv.put(KEY_DISEASES_TREATMENT, "Since the cysts will not resolve on their own, early treatment is crucial. Treatment includes addressing the underlying factors for the onset of the condition. This may include correction of nutritional disorders or hormonal treatment. The causes of these cysts are still unknown which means there are no prevention measures undertaken.");
		cv.put(KEY_DISEASES_IMAGE, "image");
		ourDatabase.insert(TABLE_DISEASES, null, cv); 
		
		cv.put(KEY_DISEASES_ID, "8");
		cv.put(KEY_DISEASES_NAME, "Foot and Mouth");
		cv.put(KEY_DISEASES_DESCRIPTION, "Foot and Mouth disease is a highly contagious viral disease and spreads very quicky. As a result of this it is a reportable disease. It is caused by seven different types of viruses which are only distinguishable in the laboratory.");
		cv.put(KEY_DISEASES_SYMPTOMS, "Fever, blister in the mouth and feet, drop in milk production, weight loss, loss of appetite, frothing from the mouth and lameness");
		cv.put(KEY_DISEASES_TREATMENT, "There is no available treatment as the animal is left to recover. It is one of the most difficult disease to control. FMD outbreaks are usually controlled by quarantines and movement restrictions, euthanasia of affected and in-contact animals, and cleansing and disinfection of affected premises, equipment and vehicles. Vaccinations areused to reduce the spread however vaccination with one serotype does not protect the aniaml against other serotypes. ");
		cv.put(KEY_DISEASES_IMAGE, "image");
		ourDatabase.insert(TABLE_DISEASES, null, cv);
		
		cv.put(KEY_DISEASES_ID, "9");
		cv.put(KEY_DISEASES_NAME, "Mastitis");
		cv.put(KEY_DISEASES_DESCRIPTION, "Mastitis is a very serious infection and can be a cause of lamb/calf mortality from starvation. Mastitis is divided into three forms; acute, chronic and subclinical. It is caused by bacteria. ");
		cv.put(KEY_DISEASES_SYMPTOMS, "Symptoms include fever, loss of appetite, depression ");
		cv.put(KEY_DISEASES_TREATMENT, "When mastitis is detected, it is important that the causal bacteria are determined in order to advise on the best treatment options. Antibiotics are injected after cow/sheep is fully milked out.");
		cv.put(KEY_DISEASES_IMAGE, "image");
		ourDatabase.insert(TABLE_DISEASES, null, cv);
		
		cv.put(KEY_DISEASES_ID, "10");
		cv.put(KEY_DISEASES_NAME, "Johne's Disease");
		cv.put(KEY_DISEASES_DESCRIPTION, "Johne’s disease is an infectious bacterial disease. It usually strikes during the first few weeks of life following the consummption of milk/food contaminated with bacteria. The disease is usually spread from an infected animal or infected material.");
		cv.put(KEY_DISEASES_SYMPTOMS, "It is slow to progress but many symptoms include; diarrhea, weight loss despite good appetite and bottle jaw.");
		cv.put(KEY_DISEASES_TREATMENT, "There is no treatment for Johne's disease as the animal will continue to deteriorate. Prevention is the only way and this is doen by testing sick looking animals and isolating them from farm. Vaccinations are available also. ");
		cv.put(KEY_DISEASES_IMAGE, "image");
		ourDatabase.insert(TABLE_DISEASES, null, cv);
		
		cv.put(KEY_DISEASES_ID, "11");
		cv.put(KEY_DISEASES_NAME, "Liver Fluke");
		cv.put(KEY_DISEASES_DESCRIPTION, "Liver Fluke is caused by a parasite Fasciloa hepatica.");
		cv.put(KEY_DISEASES_SYMPTOMS, "Symptoms include; reduced milk yields, reduced fertility, anaemia, diarrhoea and condemnation of livers. Youngstock tend to be more susceptible.");
		cv.put(KEY_DISEASES_TREATMENT, "There are numerous products available for treating Liver Fluke. Flukicides are effective against immature and adult fluke. Prevention is done in the form of pasture rotation. If possible keep animals from grazing on wet land, such as river banks etc. An appropriate worming regime should also be introduced.  ");
		cv.put(KEY_DISEASES_IMAGE, "image");
		ourDatabase.insert(TABLE_DISEASES, null, cv);
		
		
		cv.put(KEY_DISEASES_ID, "12");
		cv.put(KEY_DISEASES_NAME, "Orf Virus");
		cv.put(KEY_DISEASES_DESCRIPTION, "Orf is a highly contagious viral disease. It forms as scaby lesions on the lips and nostrils of the animal. It can be transmitted to humans. It mainly affects young stock. The scabs of infected animals contain virus, can fall off, remain in the environment and serve as a source of infection to susceptible animals. ");
		cv.put(KEY_DISEASES_SYMPTOMS, "At the early stages of the infection, sores appear as blisters and then develop as crusty scrabs. The sores are usually located on the lips, muzzle and in the mouth. Young stock may have difficulty nursing.");
		cv.put(KEY_DISEASES_TREATMENT, "There are vaccination available but should only be considered for previously infected flocks. Prevention involves quarentine of new new animals until orf is ruled out and also try to avoid bringing animals to public events, eg fairs.");
		cv.put(KEY_DISEASES_IMAGE, "image");
		ourDatabase.insert(TABLE_DISEASES, null, cv);
		
		cv.put(KEY_DISEASES_ID, "13");
		cv.put(KEY_DISEASES_NAME, "Joint Ill");
		cv.put(KEY_DISEASES_DESCRIPTION, "Joint ill is mainly a disease in young stock which usually occurs less than one week of age. It occurs as a result of infection entering via the umbilical cord at, or soon after, birth. ");
		cv.put(KEY_DISEASES_SYMPTOMS, "If the infection stays in the navel, the primary symptom is a swollen, painful navel that does not dry up, high temperature and reduced appetite. If it spreads from the navel, bacteria spreads via the bloodstream and settle in other parts of the body. Joints are usually hit by the joints which leads to stiff painful joints. Loss of appetite and depression are often witnessed.");
		cv.put(KEY_DISEASES_TREATMENT, "Early treatment is necessary to stop the spread of infection. Infected animals should be isolated and treated with antibiotics and painkillers. Prevention involves having a clean environment in which the animals lay. Applying iodine to the navel can significantly reduce the risk of bacteria entering via the navel.");
		cv.put(KEY_DISEASES_IMAGE, "image");
		ourDatabase.insert(TABLE_DISEASES, null, cv);
		
		cv.put(KEY_DISEASES_ID, "14");
		cv.put(KEY_DISEASES_NAME, "Twin Lamb Disease/Pregnancy Toxaemia");
		cv.put(KEY_DISEASES_DESCRIPTION, "Twin Lamb Disease is a metabolic disorder where the body's energy requirements are not being met, resulting from poor nutritional diet.  Ewes carrying twins are more often affected, but ewes carrying single lambs can also get the disease. Stressful events like worms, skin and  feet problems, transport can trigger Pregnancy Toxaemia. ");
		cv.put(KEY_DISEASES_SYMPTOMS, "Separation from flock is a major sign. The sheep does not run away when approached.");
		cv.put(KEY_DISEASES_TREATMENT, "Early treatment is vital. There are many nutritional supplements available. The ewe should be eating well, if not, it is unlikely she will respond to treatment.");
		cv.put(KEY_DISEASES_IMAGE, "Orf Virus");
		ourDatabase.insert(TABLE_DISEASES, null, cv);
		
		cv.put(KEY_DISEASES_ID, "15");
		cv.put(KEY_DISEASES_NAME, "Calf Pneumonia");
		cv.put(KEY_DISEASES_DESCRIPTION, "This is a major problem in dairy and beef herds and is common in calves between one to five months. Infectious agents involved include Mannheimia haemolytica, Haemophilus somnus, Infectious Bovine Rhinotracheitis (IBR), bovine Respiratory Syncytial Virus (RSV) and Parainfluenza III Virus (PI3), along with numerous others. Low environmental temperatures or draughts may also trigger this.  ");
		cv.put(KEY_DISEASES_SYMPTOMS, "Symptoms include; depressed, high temperature, raised breathing, nasel discharge, coughing and reduced food intake.");
		cv.put(KEY_DISEASES_TREATMENT, "Treatment includes antibiotics or anti-inflammatories. It is difficult to control since they are placed in pens. Improved ventilation and good nursing can reduced the onset of pneumonia. Usually if ammonia is smelled it is a sign of poor ventilation. Vaccines are available to reduce risk of infection, however they must be used alongside an effective management programme.");
		cv.put(KEY_DISEASES_IMAGE, "image");
		ourDatabase.insert(TABLE_DISEASES, null, cv);
		
	/*	
		cv.put(KEY_DISEASES_ID, "15");
		cv.put(KEY_DISEASES_NAME, "Joint Ill");
		cv.put(KEY_DISEASES_DESCRIPTION, "12");
		cv.put(KEY_DISEASES_SYMPTOMS, "Orf Virus");
		cv.put(KEY_DISEASES_TREATMENT, "12");
		cv.put(KEY_DISEASES_IMAGE, "Orf Virus");
		ourDatabase.insert(TABLE_DISEASES, null, cv);
		
	*/                    	
		
	}																																															

	/***************************** INSERT ANIMALS  Diseases**************************************/
	
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
		cv.put(KEY_CAT, "4");
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
		
		cv.put(KEY_ANI_CAT_DIS, "11");
		cv.put(KEY_ANI, "1");
		cv.put(KEY_CAT, "2");
		cv.put(KEY_DIS, "2");
		ourDatabase.insert(TABLE_ANI_CAT_DIS, null, cv);
	}
	
	
	/*********************************INSERT REPRODUCTION***************************************/
	
	public void insertReproduction(){
		ContentValues cv = new ContentValues();
		cv.put(KEY_REPRODUCTION_ID, "1");
		cv.put(KEY_REPRODUCTION_BREEDING, "Cow Breeding");
		cv.put(KEY_REPRODUCTION_GESTATION, "Cow Gestation");
		cv.put(KEY_REPRODUCTION_BIRTH, "Cow Birth");
		cv.put(KEY_REPRODUCTION_ANIMAL, "1");
		ourDatabase.insert(TABLE_REPRODUCTION, null, cv);
	
		cv.put(KEY_REPRODUCTION_ID, "2");
		cv.put(KEY_REPRODUCTION_BREEDING, "Sheep Breeding");
		cv.put(KEY_REPRODUCTION_GESTATION, "Sheep Gestation");
		cv.put(KEY_REPRODUCTION_BIRTH, "Sheep Birth");
		cv.put(KEY_REPRODUCTION_ANIMAL, "2");
		ourDatabase.insert(TABLE_REPRODUCTION, null, cv);
		
		
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
				"WHERE type_animals = 'Cow' AND type_category = ? ORDER BY name_diseases", new String[]{"Respiratory"});
 
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
	
	/*************************** GET SKIN COWS ***********************************/
	

	public Cursor getCowSkinDiseases(){
		Cursor c = ourDatabase.rawQuery("SELECT _id, name_diseases " +
				"FROM Animals, Diseases, Category " +
				"INNER JOIN Ani_Cat_Dis " + 
				"ON Ani_Cat_Dis.id_ani = Animals.id_animals AND Ani_Cat_Dis.id_cat = Category.id_category AND Ani_Cat_Dis.id_dis = Diseases._id  " +
				"WHERE type_animals = 'Cow' AND type_category = ? ORDER BY name_diseases", new String[]{"Skin Eyes Feet"});
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
	
	/*************************** GET VIRUSES COWS ***********************************/
	
	public Cursor getCowVirDiseases(){
		Cursor c = ourDatabase.rawQuery("SELECT _id, name_diseases " +
				"FROM Animals, Diseases, Category " +
				"INNER JOIN Ani_Cat_Dis " + 
				"ON Ani_Cat_Dis.id_ani = Animals.id_animals AND Ani_Cat_Dis.id_cat = Category.id_category AND Ani_Cat_Dis.id_dis = Diseases._id  " +
				"WHERE type_animals = 'Cow' AND type_category = ? ORDER BY name_diseases", new String[]{"Viruses Bacteria"});
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
	
	/*************************** GET REPRODUCTIVE COWS ***********************************/
	
	public Cursor getCowReproductiveDiseases(){
		Cursor c = ourDatabase.rawQuery("SELECT _id, name_diseases " +
				"FROM Animals, Diseases, Category " +
				"INNER JOIN Ani_Cat_Dis " + 
				"ON Ani_Cat_Dis.id_ani = Animals.id_animals AND Ani_Cat_Dis.id_cat = Category.id_category AND Ani_Cat_Dis.id_dis = Diseases._id  " +
				"WHERE type_animals = 'Cow' AND type_category = ? ORDER BY name_diseases", new String[]{"Reproductive"});
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
	

	/*************************** GET RESPIRTORY SHEEP ***********************************/
	
	public Cursor getSheepRespiratoryDiseases(){
		Cursor c = ourDatabase.rawQuery("SELECT _id, name_diseases " +
				"FROM Animals, Diseases, Category " +
				"INNER JOIN Ani_Cat_Dis " + 
				"ON Ani_Cat_Dis.id_ani = Animals.id_animals AND Ani_Cat_Dis.id_cat = Category.id_category AND Ani_Cat_Dis.id_dis = Diseases._id  " +
				"WHERE type_animals = 'Sheep' AND type_category = ? ORDER BY name_diseases", new String[]{"Respiratory"});
 
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
	
	/*************************** GET SKIN SHEEP ***********************************/

	public Cursor getSheepSkinDiseases(){
		Cursor c = ourDatabase.rawQuery("SELECT _id, name_diseases " +
				"FROM Animals, Diseases, Category " +
				"INNER JOIN Ani_Cat_Dis " + 
				"ON Ani_Cat_Dis.id_ani = Animals.id_animals AND Ani_Cat_Dis.id_cat = Category.id_category AND Ani_Cat_Dis.id_dis = Diseases._id  " +
				"WHERE type_animals = 'Sheep' AND type_category = ? ORDER BY name_diseases", new String[]{"Skin Eyes Feet"});
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
	
	/*************************** GET VIRUSES SHEEP ***********************************/
	
	public Cursor getSheepVirDiseases(){
		Cursor c = ourDatabase.rawQuery("SELECT _id, name_diseases " +
				"FROM Animals, Diseases, Category " +
				"INNER JOIN Ani_Cat_Dis " + 
				"ON Ani_Cat_Dis.id_ani = Animals.id_animals AND Ani_Cat_Dis.id_cat = Category.id_category AND Ani_Cat_Dis.id_dis = Diseases._id  " +
				"WHERE type_animals = 'Sheep' AND type_category = ? ORDER BY name_diseases", new String[]{"Viruses Bacteria"});
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
	
	/*************************** GET REPRODUCTIVE SHEEP ***********************************/
	
	public Cursor getSheepReproductiveDiseases(){
		Cursor c = ourDatabase.rawQuery("SELECT _id, name_diseases " +
				"FROM Animals, Diseases, Category " +
				"INNER JOIN Ani_Cat_Dis " + 
				"ON Ani_Cat_Dis.id_ani = Animals.id_animals AND Ani_Cat_Dis.id_cat = Category.id_category AND Ani_Cat_Dis.id_dis = Diseases._id  " +
				"WHERE type_animals = 'Sheep' AND type_category = ? ORDER BY name_diseases", new String[]{"Reproductive"});
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
	
	
	/*************************** GET RESPIRTORY CALF ***********************************/
	
	public Cursor getCalfRespiratoryDiseases(){
		Cursor c = ourDatabase.rawQuery("SELECT _id, name_diseases " +
				"FROM Animals, Diseases, Category " +
				"INNER JOIN Ani_Cat_Dis " + 
				"ON Ani_Cat_Dis.id_ani = Animals.id_animals AND Ani_Cat_Dis.id_cat = Category.id_category AND Ani_Cat_Dis.id_dis = Diseases._id  " +
				"WHERE type_animals = 'Calf' AND type_category = ? ORDER BY name_diseases", new String[]{"Respiratory"});
 
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
	
	/*************************** GET SKIN CALF ***********************************/

	public Cursor getCalfSkinDiseases(){
		Cursor c = ourDatabase.rawQuery("SELECT _id, name_diseases " +
				"FROM Animals, Diseases, Category " +
				"INNER JOIN Ani_Cat_Dis " + 
				"ON Ani_Cat_Dis.id_ani = Animals.id_animals AND Ani_Cat_Dis.id_cat = Category.id_category AND Ani_Cat_Dis.id_dis = Diseases._id  " +
				"WHERE type_animals = 'Calf' AND type_category = ? ORDER BY name_diseases", new String[]{"Skin Eyes Feet"});
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
	
	/*************************** GET VIRUSES CALF ***********************************/
	
	public Cursor getCalfVirDiseases(){
		Cursor c = ourDatabase.rawQuery("SELECT _id, name_diseases " +
				"FROM Animals, Diseases, Category " +
				"INNER JOIN Ani_Cat_Dis " + 
				"ON Ani_Cat_Dis.id_ani = Animals.id_animals AND Ani_Cat_Dis.id_cat = Category.id_category AND Ani_Cat_Dis.id_dis = Diseases._id  " +
				"WHERE type_animals = 'Calf' AND type_category = ? ORDER BY name_diseases", new String[]{"Viruses Bacteria"});
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
	
	/*************************** GET REPRODUCTIVE CALF ***********************************/
	
	public Cursor getCalfReproductiveDiseases(){
		Cursor c = ourDatabase.rawQuery("SELECT _id, name_diseases " +
				"FROM Animals, Diseases, Category " +
				"INNER JOIN Ani_Cat_Dis " + 
				"ON Ani_Cat_Dis.id_ani = Animals.id_animals AND Ani_Cat_Dis.id_cat = Category.id_category AND Ani_Cat_Dis.id_dis = Diseases._id  " +
				"WHERE type_animals = 'Calf' AND type_category = ? ORDER BY name_diseases", new String[]{"Reproductive"});
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
	
	
	/*************************** GET RESPIRTORY LAMB ***********************************/
	
	public Cursor getLambRespiratoryDiseases(){
		Cursor c = ourDatabase.rawQuery("SELECT _id, name_diseases " +
				"FROM Animals, Diseases, Category " +
				"INNER JOIN Ani_Cat_Dis " + 
				"ON Ani_Cat_Dis.id_ani = Animals.id_animals AND Ani_Cat_Dis.id_cat = Category.id_category AND Ani_Cat_Dis.id_dis = Diseases._id  " +
				"WHERE type_animals = 'Lamb' AND type_category = ? ORDER BY name_diseases", new String[]{"Respiratory"});
 
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
	
	/*************************** GET SKIN LAMB ***********************************/

	public Cursor getLambSkinDiseases(){
		Cursor c = ourDatabase.rawQuery("SELECT _id, name_diseases " +
				"FROM Animals, Diseases, Category " +
				"INNER JOIN Ani_Cat_Dis " + 
				"ON Ani_Cat_Dis.id_ani = Animals.id_animals AND Ani_Cat_Dis.id_cat = Category.id_category AND Ani_Cat_Dis.id_dis = Diseases._id  " +
				"WHERE type_animals = 'Lamb' AND type_category = ? ORDER BY name_diseases", new String[]{"Skin Eyes Feet"});
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
	
	/*************************** GET VIRUSES LAMB ***********************************/
	
	public Cursor getLambVirDiseases(){
		Cursor c = ourDatabase.rawQuery("SELECT _id, name_diseases " +
				"FROM Animals, Diseases, Category " +
				"INNER JOIN Ani_Cat_Dis " + 
				"ON Ani_Cat_Dis.id_ani = Animals.id_animals AND Ani_Cat_Dis.id_cat = Category.id_category AND Ani_Cat_Dis.id_dis = Diseases._id  " +
				"WHERE type_animals = 'Lamb' AND type_category = ? ORDER BY name_diseases", new String[]{"Viruses Bacteria"});
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
	
	/*************************** GET REPRODUCTIVE LAMB ***********************************/
	
	public Cursor getLambReproductiveDiseases(){
		Cursor c = ourDatabase.rawQuery("SELECT _id, name_diseases " +
				"FROM Animals, Diseases, Category " +
				"INNER JOIN Ani_Cat_Dis " + 
				"ON Ani_Cat_Dis.id_ani = Animals.id_animals AND Ani_Cat_Dis.id_cat = Category.id_category AND Ani_Cat_Dis.id_dis = Diseases._id  " +
				"WHERE type_animals = 'Lamb' AND type_category = ? ORDER BY name_diseases", new String[]{"Reproductive"});
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
	
/***************************** Get disease symptoms  ********************************************/
	
	public String getSymptomsDisease(long diseaseID){
		
		Cursor c = ourDatabase.rawQuery("SELECT " + KEY_DISEASES_SYMPTOMS+ " FROM " +TABLE_DISEASES+ " WHERE " + DatabaseHelper.KEY_DISEASES_ID + "  = " +diseaseID ,null);
		String result = "";
		int isymptoms = c.getColumnIndex(KEY_DISEASES_SYMPTOMS);
				for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
					result = result + c.getString(isymptoms); 
					
				}
				
				return result;
		
		
	}
	
	
/***************************** Get disease treatment  ********************************************/
	
	public String getTreatmentDisease(long diseaseID){
		
		Cursor c = ourDatabase.rawQuery("SELECT " + KEY_DISEASES_TREATMENT+ " FROM " +TABLE_DISEASES+ " WHERE " + DatabaseHelper.KEY_DISEASES_ID + "  = " +diseaseID ,null);
		String result = "";
		int itreatment = c.getColumnIndex(KEY_DISEASES_TREATMENT);
				for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
					result = result + c.getString(itreatment); 
					
				}
				
				return result;
		
		
	}
	
	
	
	
	/**************************************REPRODUCTION***********************************/
	/***********************************COW*******************************************/
	
	public String getCowBreeding(){
		Cursor c = ourDatabase.rawQuery("SELECT " + KEY_REPRODUCTION_BREEDING +
		 		" FROM " + TABLE_REPRODUCTION +
		 		" WHERE " + KEY_REPRODUCTION_ANIMAL + " = ? ", new String[]{"1"});
		 String result = "";
			
			int iBreeding = c.getColumnIndex("breeding_reproduction");
			for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				//result = result + c.getString(iRow) + " " + c.getString(iName) + " " + c.getString(iDesc) + " " + c.getString(iImage) + " \n";
				result = result + c.getString(iBreeding) + " \n"; 
			}
			return result;
		
	}
	
	public String getCowGestation(){
		Cursor c = ourDatabase.rawQuery("SELECT " + KEY_REPRODUCTION_GESTATION +
		 		" FROM " + TABLE_REPRODUCTION +
		 		" WHERE " + KEY_REPRODUCTION_ANIMAL + " = ? ", new String[]{"1"});
		 String result = "";
			
			int iGestation = c.getColumnIndex("gestation_reproduction");
			for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				//result = result + c.getString(iRow) + " " + c.getString(iName) + " " + c.getString(iDesc) + " " + c.getString(iImage) + " \n";
				result = result + c.getString(iGestation) + " \n"; 
			}
			return result;
		
	}
	
	public String getCowBirth(){
		Cursor c = ourDatabase.rawQuery("SELECT " + KEY_REPRODUCTION_BIRTH +
		 		" FROM " + TABLE_REPRODUCTION +
		 		" WHERE " + KEY_REPRODUCTION_ANIMAL + " = ? ", new String[]{"1"});
		 String result = "";
			
			int iBirth = c.getColumnIndex("birth_reproduction");
			for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				//result = result + c.getString(iRow) + " " + c.getString(iName) + " " + c.getString(iDesc) + " " + c.getString(iImage) + " \n";
				result = result + c.getString(iBirth) + " \n"; 
			}
			return result;
		
	}
	
	
	/******************************SHEEP***************************************************/
	
	public String getSheepBreeding(){
		Cursor c = ourDatabase.rawQuery("SELECT " + KEY_REPRODUCTION_BREEDING +
		 		" FROM " + TABLE_REPRODUCTION +
		 		" WHERE " + KEY_REPRODUCTION_ANIMAL + " = ? ", new String[]{"2"});
		 String result = "";
			
			int iBreeding = c.getColumnIndex("breeding_reproduction");
			for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				//result = result + c.getString(iRow) + " " + c.getString(iName) + " " + c.getString(iDesc) + " " + c.getString(iImage) + " \n";
				result = result + c.getString(iBreeding) + " \n"; 
			}
			return result;
		
	}
	
	public String getSheepGestation(){
		Cursor c = ourDatabase.rawQuery("SELECT " + KEY_REPRODUCTION_GESTATION +
		 		" FROM " + TABLE_REPRODUCTION +
		 		" WHERE " + KEY_REPRODUCTION_ANIMAL + " = ? ", new String[]{"2"});
		 String result = "";
			
			int iGestation = c.getColumnIndex("gestation_reproduction");
			for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				//result = result + c.getString(iRow) + " " + c.getString(iName) + " " + c.getString(iDesc) + " " + c.getString(iImage) + " \n";
				result = result + c.getString(iGestation) + " \n"; 
			}
			return result;
		
	}
	
	public String getSheepBirth(){
		Cursor c = ourDatabase.rawQuery("SELECT " + KEY_REPRODUCTION_BIRTH +
		 		" FROM " + TABLE_REPRODUCTION +
		 		" WHERE " + KEY_REPRODUCTION_ANIMAL + " = ? ", new String[]{"2"});
		 String result = "";
			
			int iBirth = c.getColumnIndex("birth_reproduction");
			for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				//result = result + c.getString(iRow) + " " + c.getString(iName) + " " + c.getString(iDesc) + " " + c.getString(iImage) + " \n";
				result = result + c.getString(iBirth) + " \n"; 
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