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

            var meal_type by remember {
                mutableStateOf("")
            }
            var time_of_the_day by remember {
                mutableStateOf("")
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Text("My Meal",
                fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
                Text("Plan your meal",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold )
                Divider()
                Spacer(modifier = Modifier.size(30.dp))


                OutlinedTextField(
                    value = time_of_the_day,
                    onValueChange = { text ->
                        time_of_the_day = text
                    },
                    placeholder = {
                        Text("Enter time of day:Morning;Mid-morning,Afternoon, Mid-afternoon or dinner")
                    }

                )
                Spacer(modifier = Modifier.size(30.dp))
                Row {
                    Button(onClick = {
                        meal_type = when(time_of_the_day){
                            "Morning" -> "Spread mashed avocado on a slice of whole-grain toast"
                            "Mid-morning" -> "Peanut Butter Banana Wraps"
                            "Afternoon" -> "Grilled Chicken Wrap:"
                            "Mid-afternoon" -> "cranberries or raisins), seeds (like sunflower)"
                            "Dinner" -> "Stir-Fried Veggie Noodles with Chicken"
                            else -> ("Invalid food, please reset and refer to input box.")

                        }

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


