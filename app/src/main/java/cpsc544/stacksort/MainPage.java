package cpsc544.stacksort;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.text.TextWatcher;


public class MainPage extends AppCompatActivity {
    //*******************************************************************************************
    // the lines of code below are in order to make the application begin on the main page
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);


        // variable definitions
        ImageButton getHelp = (ImageButton) findViewById(R.id.helpBtn);
        ImageButton getAbout = (ImageButton) findViewById(R.id.aboutButton);
        final Button getSort = (Button) findViewById(R.id.sortBtn);
        final EditText in;          // in is the number pad on main page
        in = (EditText) findViewById(R.id.userInput);
        final TextView out;         // out is the name of the blank textbox we use as our output

// the textwatcher below is used to force the user to use more than 1 number and less than 9 on the input
        in.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable arg0) {
                boolean isReady =in.getText().toString().length()>1 && in.getText().toString().length()<9;
                getSort.setEnabled(isReady);

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });


        //***************************************************************************************
        // the following lines of code are to make the help button take you to the help activity
        getHelp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View mView) {
                Intent help = new Intent(MainPage.this, Help.class);
                startActivity(help);
            }
        });
        //****************************************************************************************
        // The following lines of code are to make the about button take you to the about us page
        getAbout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View nView) {
                Intent about = new Intent(MainPage.this, AboutUSActivity.class);
                startActivity(about);
            }
        });
// the business side of the sort button

        getSort.setOnClickListener(new View.OnClickListener() {
            public void onClick(View oView) {

                EditText name = (EditText) findViewById(R.id.userInput);
            }
        });

        out = (TextView) findViewById(R.id.userOutput);
        final Button sortingButton = (Button) findViewById(R.id.sortBtn);
        sortingButton.setEnabled(false);
        sortingButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String display = in.getText().toString();                       // converts input from editText to String
                out.setText("");                                                // this is to clear old entries
                int length = display.length();                                  // will be the lenght of the array
                int array[] = new int[length];                                    // this is to store the input string into

                /* this for loop converts the string into an integer array */
                for (int i = 0; i < length; i++) {
                    array[i] = Integer.parseInt(display.substring(i, i + 1));
                }

// insertion sort
                int i;
                int j;

                    out.append("to sort array: ");
                for(i=0;i<length;i++)
                    out.append( array[i] + " ");
                for ( i = 1; i < length; i++)
                {
                    int key = array[i];
                    j = i-1;
                    while ( (j > -1) && ( array[j] > key ) )
                    {
                        array[j+1] = array[j];
                        j--;
                    }
                    array[j+1]=key;
                    out.append("\n");
                    for(int k=0;k<length;k++)
                    {
                        out.append(array[k] + " ");
                    }
                }
                out.append(" ");
                out.append("\n");
                for(i=0;i<length;i++)
                    out.append(array[i] + " ");
            }

        });
    }
}



