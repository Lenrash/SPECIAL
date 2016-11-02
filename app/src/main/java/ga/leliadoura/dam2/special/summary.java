package ga.leliadoura.dam2.special;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Summary extends AppCompatActivity{

    private TextView text;

    private int strength;
    private int perception;
    private int endurance;
    private int charisma;
    private int intelligence;
    private int agility;
    private int luck;

    private String name, gender, rifleman, barter, medic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summary);

        getDataFromMainActivity();
        printData();

    }

    private void getDataFromMainActivity(){
        strength = getIntent().getIntExtra("strength", 0);
        perception = getIntent().getIntExtra("perception", 0);
        endurance = getIntent().getIntExtra("endurance", 0);
        charisma = getIntent().getIntExtra("charisma", 0);
        intelligence = getIntent().getIntExtra("intelligence", 0);
        agility = getIntent().getIntExtra("agility", 0);
        luck = getIntent().getIntExtra("luck", 0);

        name = getIntent().getStringExtra("name");

        gender = getIntent().getStringExtra("gender");

    }

    private void printData(){
        text = (TextView)findViewById(R.id.summary_text);

        text.setText (getText(R.string.strength) + " " + String.valueOf(strength)
                + "\n" + getText(R.string.perception) + " " + String.valueOf(perception)
                + "\n" + getText(R.string.endurance) + " " + String.valueOf(endurance)
                + "\n" + getText(R.string.charisma) + " " + String.valueOf(charisma)
                + "\n" + getText(R.string.intelligence) + " " + String.valueOf(intelligence)
                + "\n" + getText(R.string.agility) + " " + String.valueOf(agility)
                + "\n" + getText(R.string.luck) + " " + String.valueOf(luck)
                + "\n" + getText(R.string.name)+ " " + name
                + "\n" + getText(R.string.gender)+ " " + gender);
    }
}
