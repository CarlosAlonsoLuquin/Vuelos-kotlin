package com.example.vueloskotlin.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vueloskotlin.R

@Composable
fun RegisterScreen(
    onRegisterSuccess: () -> Unit,
    onBackToLogin: () -> Unit,
    onBackToWelcome: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo1),
            contentDescription = "Logo",
            modifier = Modifier.size(80.dp)
        )

        Text(text = "Create account", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Text(
            text = "Sign up, enter all your details, and discover the best way to travel", 
            color = Color.Gray, 
            fontSize = 14.sp,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
            modifier = Modifier.padding(top = 8.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Personal Information Section
        SectionHeader("Personal Information")
        RegisterField(label = "Name(s)", placeholder = "Full name")
        RegisterField(label = "Surnames", placeholder = "Full surname")
        RegisterField(label = "Birthdate", placeholder = "Ex: DD/MM/YYYY")

        Spacer(modifier = Modifier.height(16.dp))

        // Contact Information Section
        SectionHeader("Contact Information")
        RegisterField(label = "Email", placeholder = "E.g.: tucorreo@gmail.com")
        RegisterField(label = "Cell phone", placeholder = "+52 6241261261")

        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            Checkbox(
                checked = false, 
                onCheckedChange = {},
                colors = CheckboxDefaults.colors(checkedColor = Color(0xFFD38157))
            )
            Text("Terms and Conditions", fontSize = 12.sp, color = Color.Gray)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onRegisterSuccess,
            modifier = Modifier.fillMaxWidth().height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD38157)),
            shape = RoundedCornerShape(28.dp)
        ) {
            Text("Create account", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }

        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Do you already have an account?", fontSize = 14.sp)
            TextButton(onClick = onBackToLogin) {
                Text("Log in", color = Color(0xFFD38157), fontSize = 14.sp, fontWeight = FontWeight.Bold)
            }
        }

        TextButton(onClick = onBackToWelcome) {
            Text("Return to VuelaYa", color = Color.Black, fontSize = 14.sp, fontWeight = FontWeight.Medium)
        }
        
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun SectionHeader(text: String) {
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = Color.Black,
        modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp)
    )
}

@Composable
fun RegisterField(label: String, placeholder: String) {
    Column(modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)) {
        Text(text = label, fontSize = 12.sp, color = Color.Gray, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text(placeholder, color = Color.LightGray) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color(0xFFEEEEEE),
                focusedBorderColor = Color(0xFFD38157)
            )
        )
    }
}
