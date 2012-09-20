package vinova.project.PetroManager;

import android.app.Activity;
import android.os.Bundle;

public class MainPetroManager extends Activity {
	PetroHelper db;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        db= new PetroHelper(this);
        db.addCostPetro("20/5/2004", "40k", "1234");
        long id=db.addFixing("30/4", "Hai xom", "tot");
        db.addFixingDetail(String.valueOf(id), "thung xam", "30k");
        db.addFixingDetail(String.valueOf(id), "No xe", "50k");
        db.close();
    }
}
