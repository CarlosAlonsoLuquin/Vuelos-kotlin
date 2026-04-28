package com.example.vueloskotlin.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vueloskotlin.R

@Composable
fun HomeScreen() {
    var fromText by remember { mutableStateOf("New York (NYC)") }
    var toText by remember { mutableStateOf("Los Angeles (LAX)") }

    Scaffold(
        bottomBar = {
            NavigationBar(containerColor = Color.White) {
                NavigationBarItem(
                    icon = { 
                        Icon(
                            painter = painterResource(id = R.drawable.home), 
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        ) 
                    },
                    label = { Text("Home", fontSize = 10.sp) },
                    selected = true,
                    onClick = {},
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFF4A90E2),
                        unselectedIconColor = Color.Gray,
                        selectedTextColor = Color(0xFF4A90E2),
                        unselectedTextColor = Color.Gray,
                        indicatorColor = Color.Transparent
                    )
                )
                NavigationBarItem(
                    icon = { 
                        Icon(
                            painter = painterResource(id = R.drawable.search_icon), 
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        ) 
                    },
                    label = { Text("Search", fontSize = 10.sp) },
                    selected = false,
                    onClick = {},
                    colors = NavigationBarItemDefaults.colors(unselectedIconColor = Color.Gray)
                )
                NavigationBarItem(
                    icon = { 
                        Icon(
                            painter = painterResource(id = R.drawable.bookings), 
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        ) 
                    },
                    label = { Text("Bookings", fontSize = 10.sp) },
                    selected = false,
                    onClick = {},
                    colors = NavigationBarItemDefaults.colors(unselectedIconColor = Color.Gray)
                )
                NavigationBarItem(
                    icon = { 
                        Icon(
                            painter = painterResource(id = R.drawable.profile), 
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        ) 
                    },
                    label = { Text("Profile", fontSize = 10.sp) },
                    selected = false,
                    onClick = {},
                    colors = NavigationBarItemDefaults.colors(unselectedIconColor = Color.Gray)
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .background(Color(0xFFF5F5F5))
        ) {
            // Header naranja
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFD38157))
                    .padding(horizontal = 16.dp, vertical = 32.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo2),
                        contentDescription = "Logo",
                        modifier = Modifier.size(60.dp)
                    )
                    
                    Row {
                        Icon(
                            painter = painterResource(id = R.drawable.notification), 
                            contentDescription = null, 
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.profile), 
                            contentDescription = null, 
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }

            // Formulario de búsqueda
            Card(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .offset(y = (-24.dp))
                    .fillMaxWidth(),
                elevation = CardDefaults.cardElevation(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(), 
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            shape = RoundedCornerShape(20.dp),
                            color = Color(0xFFFEEAD1),
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.despegar),
                                    contentDescription = null,
                                    tint = Color(0xFFD38157),
                                    modifier = Modifier.size(14.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("Round Trip", color = Color(0xFFD38157), fontSize = 12.sp, fontWeight = FontWeight.Bold)
                            }
                        }
                        
                        Spacer(modifier = Modifier.width(16.dp))
                        
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                painter = painterResource(id = R.drawable.flecha_correcta),
                                contentDescription = null,
                                tint = Color.Gray,
                                modifier = Modifier.size(14.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("One Way", color = Color.Gray, fontSize = 12.sp, fontWeight = FontWeight.Medium)
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(20.dp))
                    
                    Text("FROM", fontSize = 10.sp, color = Color.Gray, fontWeight = FontWeight.Bold)
                    OutlinedTextField(
                        value = fromText,
                        onValueChange = { fromText = it },
                        modifier = Modifier.fillMaxWidth(),
                        leadingIcon = {
                            Icon(painter = painterResource(id = R.drawable.despegar), contentDescription = null, tint = Color(0xFFD38157), modifier = Modifier.size(20.dp))
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = Color(0xFFEEEEEE),
                            focusedBorderColor = Color(0xFFD38157)
                        ),
                        shape = RoundedCornerShape(8.dp)
                    )
                    
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
                        IconButton(
                            onClick = { 
                                val temp = fromText
                                fromText = toText
                                toText = temp
                            },
                            modifier = Modifier
                                .offset(y = 10.dp, x = (-8).dp)
                                .size(32.dp)
                                .background(Color.White, CircleShape)
                                .clip(CircleShape)
                                .padding(4.dp)
                        ) {
                            Icon(painter = painterResource(id = R.drawable.flechas), contentDescription = null, tint = Color.Gray)
                        }
                    }

                    Text("TO", fontSize = 10.sp, color = Color.Gray, fontWeight = FontWeight.Bold)
                    OutlinedTextField(
                        value = toText,
                        onValueChange = { toText = it },
                        modifier = Modifier.fillMaxWidth(),
                        leadingIcon = {
                            Icon(painter = painterResource(id = R.drawable.aterrisar), contentDescription = null, tint = Color(0xFFD38157), modifier = Modifier.size(20.dp))
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = Color(0xFFEEEEEE),
                            focusedBorderColor = Color(0xFFD38157)
                        ),
                        shape = RoundedCornerShape(8.dp)
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text("DEPARTURE", fontSize = 10.sp, color = Color.Gray, fontWeight = FontWeight.Bold)
                            OutlinedTextField(
                                value = "Mar 15",
                                onValueChange = {},
                                modifier = Modifier.fillMaxWidth(),
                                leadingIcon = {
                                    Icon(painter = painterResource(id = R.drawable.reserva), contentDescription = null, tint = Color(0xFFD38157), modifier = Modifier.size(16.dp))
                                },
                                readOnly = true,
                                shape = RoundedCornerShape(8.dp),
                                colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = Color(0xFFEEEEEE))
                            )
                        }
                        Column(modifier = Modifier.weight(1f)) {
                            Text("RETURN", fontSize = 10.sp, color = Color.Gray, fontWeight = FontWeight.Bold)
                            OutlinedTextField(
                                value = "Mar 22",
                                onValueChange = {},
                                modifier = Modifier.fillMaxWidth(),
                                leadingIcon = {
                                    Icon(painter = painterResource(id = R.drawable.reserva), contentDescription = null, tint = Color(0xFFD38157), modifier = Modifier.size(16.dp))
                                },
                                readOnly = true,
                                shape = RoundedCornerShape(8.dp),
                                colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = Color(0xFFEEEEEE))
                            )
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(24.dp))
                    
                    Button(
                        onClick = {},
                        modifier = Modifier.fillMaxWidth().height(50.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD38157)),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.buscarblanco), 
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Search Flights", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }
                }
            }
            
            Text(
                "Exclusive offers for you",
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black
            )
            
            val offers = listOf(
                Offer("Japan", "$889", R.drawable.japan),
                Offer("England", "$599", R.drawable.inglaterra),
                Offer("China", "$789", R.drawable.china)
            )

            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.padding(bottom = 32.dp)
            ) {
                items(offers) { offer ->
                    OfferCard(offer)
                }
            }
        }
    }
}

data class Offer(val name: String, val price: String, val imageRes: Int)

@Composable
fun OfferCard(offer: Offer) {
    Card(
        modifier = Modifier
            .width(160.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {
            Image(
                painter = painterResource(id = offer.imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Column(modifier = Modifier.padding(12.dp)) {
                Text(
                    text = offer.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = offer.price,
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 18.sp
                )
            }
        }
    }
}
