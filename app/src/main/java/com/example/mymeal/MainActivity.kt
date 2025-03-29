package com.example.mymeal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //Declaring Variables
            var meal_type by remember {
                mutableStateOf("")
            }
            var anyCase by remember {
                mutableStateOf("")
            }
            var time_of_the_day by remember {
                mutableStateOf("")
            }
            //column to align items on the android app.
            Column(
                //Center everything on the app
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                //name of the app at the top.
                Text("My Meal",
                    //size of the app name
                fontSize = 30.sp,
                    //To make the app name bold
                    fontWeight = FontWeight.Bold
                )
                //The instruction what the user should type in the text box right above the textbox
                Text("Plan your meal",
                    //font size of the instruction text
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold )
                //the divider line between textbox and title
                Divider()
                //The spacing the items on the app.
                Spacer(modifier = Modifier.size(30.dp))
                //inserting the textbox on the app
                OutlinedTextField(

                    value = time_of_the_day,
                    onValueChange = { text ->
                        time_of_the_day = text
                    },
                    //This to show the instructions in the textbox.
                    placeholder = {
                        Text("Enter time of day:Morning;Mid-morning,Afternoon, Mid-afternoon or Dinner")
                    }

                )
                Spacer(modifier = Modifier.size(30.dp))
                //add buttons next to each other
                Row {
                    Button(onClick = {
                        //validation in enter button
                        meal_type = if (time_of_the_day == "Morning"){
                            "Spread mashed avocado on a slice of whole-grain toast"
                    }else if(time_of_the_day == "Mid-morning"){
                        "Peanut Butter Banana Wraps"
                    }else if(time_of_the_day == "Afternoon") {
                            "Peanut Butter Banana Wraps"
                        }else if(time_of_the_day == "Mid-afternoon"){
                            "cranberries or raisins), seeds (like sunflower)"
                        }else if(time_of_the_day == "Dinner"){
                           "Stir-Fried Veggie Noodles with Chicken"
                        } else
                            "Invalid time, please reset and refer to input box."

                    }) {
                        Text("Enter")

                    }
                    Button(onClick = { meal_type =""
                        time_of_the_day = ""}) {
                        Text("Reset")

                    }

                }
                Text("$time_of_the_day preferable food would be:",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text("$meal_type",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold )
            }
        }
    }
}


