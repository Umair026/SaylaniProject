package com.example.omii026.myfirebase;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;


public class MainActivity extends ActionBarActivity {

    String pushKey;
    Firebase pRef;
    Firebase nPRef;
    int a;
    EditText text1,text2,text3,text4,text5,text6;
    Button signin,signup,create;
    String tv6,tv2,tv3,tv4,tv5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);


        final Firebase ref = new Firebase("https://tvv.firebaseio.com/");
        text2 = (EditText) findViewById(R.id.text2);
        text3 = (EditText) findViewById(R.id.text3);
        text4 = (EditText) findViewById(R.id.text4);
        text5 = (EditText) findViewById(R.id.text5);
        text6 = (EditText) findViewById(R.id.text6);

        text2.setText("uumair99@hotmail.com");
        text3.setText("123");

        tv2 = text2.getText().toString();
        tv3 = text3.getText().toString();
        tv4 = text4.getText().toString();
        tv5 = text5.getText().toString();
        tv6 = text6.getText().toString();

        final RelativeLayout signInLayout = (RelativeLayout) findViewById(R.id.layout_login);

        final RelativeLayout signupLayout = (RelativeLayout) findViewById(R.id.layout_signup);

        ((Button) findViewById(R.id.create)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(!(tv5.equals("") && tv6.equals("") && tv4.equals(""))) {
                    ref.createUser(text5.getText().toString(), text6.getText().toString(), new Firebase.ValueResultHandler<Map<String,Object>>(){

                        @Override
                        public void onSuccess(Map<String, Object> stringObjectMap) {
                            Toast.makeText(MainActivity.this, "userCreated->"+stringObjectMap.get("uid"), Toast.LENGTH_SHORT).show();
                            signInLayout.setVisibility(View.VISIBLE);
                            signInLayout.setVisibility(View.GONE);
                        }

                        @Override
                        public void onError(FirebaseError firebaseError) {
                            Toast.makeText(MainActivity.this, "creation Error->"+firebaseError.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
//                }else
//                {
//                    Toast.makeText(MainActivity.this, "field is empty", Toast.LENGTH_SHORT).show();
//                }
            }
        });
        ((Button) findViewById(R.id.signin)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(!(tv2.equals("") && tv3.equals(""))) {
                    ref.authWithPassword(text2.getText().toString(),text3.getText().toString(),new Firebase.AuthResultHandler(){

                        @Override
                        public void onAuthenticated(AuthData authData) {
                            Toast.makeText(MainActivity.this, "auth id-> "+authData.getUid() , Toast.LENGTH_SHORT).show();

//                            Intent intent = new Intent(MainActivity.this,MainActivity2Activity.class);
//                            startActivity(intent);
                            FragmentManager fragmentManager = getFragmentManager();
                            fragmentManager.beginTransaction().add(R.id.container,new Page1()).addToBackStack(null).commit();
                        }

                        @Override
                        public void onAuthenticationError(FirebaseError firebaseError) {
                            Toast.makeText(MainActivity.this, "Autherror->"+firebaseError.getMessage() , Toast.LENGTH_SHORT).show();
                        }
                    });

//                }else
//                {
//                    Toast.makeText(MainActivity.this, "field is empty", Toast.LENGTH_SHORT).show();
//                }
            }
        });
        ((Button) findViewById(R.id.signup)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                signInLayout.setVisibility(View.GONE);
                signupLayout.setVisibility(View.VISIBLE);

            }
        });



//        ((Button) findViewById(R.id.click)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                ref.child("helo" + a).push().setValue("testing" + "-> " + a++);
//
//            }
//        });
//        ((Button) findViewById(R.id.click2)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ref.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        Log.d("Umair", "onDataChange call" + dataSnapshot.getValue());
//                    }
//
//                    @Override
//                    public void onCancelled(FirebaseError firebaseError) {
//
//                    }
//                });
//            }
//        });
//
//        ((Button) findViewById(R.id.click3)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//               ref.addChildEventListener(new ChildEventListener() {
//                   @Override
//                   public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                       Log.d("Umair3","OnChildAdded"+"  "+ dataSnapshot.getKey()+" s= "+s );
//                   }
//
//                   @Override
//                   public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//                       Log.d("Umair3","OnChildChanged"+ dataSnapshot.getKey()+" s= "+s);
//                       ref.child(dataSnapshot.getKey()).setValue("value-Changed");
//
//                   }
//
//                   @Override
//                   public void onChildRemoved(DataSnapshot dataSnapshot) {
//                       Log.d("Umair3","OnChildRemoved"+ dataSnapshot.getKey());
//                   }
//
//                   @Override
//                   public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//                       Log.d("Umair3","OnChildMoved"+ dataSnapshot.getValue()+" s= "+s);
//
//                   }
//
//                   @Override
//                   public void onCancelled(FirebaseError firebaseError) {
//                       Log.d("Umair3","onCancelled"+ firebaseError.toString());
//
//                   }
//               });
//            }
//        });

//        ref.child("hello").push().setValue("hello bro");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
