package com.example.uiassignment

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp

data class Car(
    val imageResId: Int,
    val name: String,
    val distance: String,
    val fuel: String,
    val price: String?
)

data class User(
    val imageResId: Int,
    val name: String,
    val amount: String
)

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_info),
                contentDescription = "Notifications"
            )
            Text(
                text = "Information",
                modifier = Modifier
                    .padding(start = 8.dp), // Adjust padding as needed
                fontWeight = FontWeight.W500,
                fontSize = TextUnit(16f, type = TextUnitType.Sp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Icon(
                painter = painterResource(id = R.drawable.ic_bell),
                contentDescription = "Notifications"
            )
            Text(
                text = "Notifications",
                modifier = Modifier
                    .padding(start = 8.dp), // Adjust padding as needed
                fontWeight = FontWeight.W500,
                fontSize = TextUnit(16f, type = TextUnitType.Sp)
            )
        }
    }
}

@Composable
fun CarCard(car: Car, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.theme_grey))
    ) {
        Column(
            modifier = Modifier.padding(24.dp)
        ) {
            Text(
                modifier = Modifier.padding(bottom = 16.dp),
                text = "NEAREST CAR",
                fontSize = TextUnit(value = 14f, type = TextUnitType.Sp),
                letterSpacing = TextUnit(value = 2f, type = TextUnitType.Sp),
                fontWeight = FontWeight.W300
            )
            Image(
                modifier = Modifier
                    .size(width = 306.dp, height = 144.dp)
                    .offset(x = (-80).dp),
                painter = painterResource(id = car.imageResId),
                contentScale = ContentScale.FillBounds,
                contentDescription = car.name,
            )
            Text(
                text = car.name,
                fontSize = TextUnit(value = 24f, type = TextUnitType.Sp),
                fontWeight = FontWeight.W500
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        modifier = Modifier.size(16.dp),
                        painter = painterResource(id = R.drawable.ic_distance),
                        contentDescription = "Distance",
                        tint = Color.Gray
                    )
                    Text(
                        modifier = Modifier.padding(start = 4.dp, end = 32.dp),
                        text = car.distance,
                        color = Color.Gray
                    )
                    Icon(
                        modifier = Modifier.size(16.dp),
                        painter = painterResource(id = R.drawable.ic_fuel),
                        contentDescription = "Fuel",
                        tint = Color.Gray
                    )
                    Text(
                        modifier = Modifier.padding(start = 4.dp, end = 16.dp),
                        text = car.fuel,
                        color = Color.Gray
                    )
                }
                Text(
                    text = car.price ?: "",
                    fontWeight = FontWeight.Bold,
                    fontSize = TextUnit(14f, type = TextUnitType.Sp)
                )
            }
        }
    }
}

@Composable
fun MapCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.theme_grey))
    ) {
        Image(
            painter = painterResource(id = R.drawable.image_maps),
            contentDescription = "Map",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
    }
}

@Composable
fun UserCard(user: User, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.theme_grey))
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = user.imageResId),
                    contentDescription = user.name,
                    modifier = Modifier.size(height = 74.dp, width = 74.dp),
                )
                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    text = user.name,
                    fontWeight = FontWeight.W400,
                    fontSize = TextUnit(14f, type = TextUnitType.Sp))
                Text(
                    text = user.amount,
                    fontWeight = FontWeight.Bold,
                    fontSize = TextUnit(14f, type = TextUnitType.Sp)
                )
            }
        }
    }
}

@Composable
fun MoreCarsSection(cars: List<Car>, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.midnight))
    ) {
        Column {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "More Cars",
                    color = Color.LightGray
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_menu),
                    contentDescription = "Menu",
                    tint = Color.LightGray
                )
            }
            LazyColumn {
                items(cars) { car ->
                    CarItem(car = car)
                }
            }
        }
    }
}

@Composable
fun CarItem(car: Car) {
    Row(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = car.name,
                fontSize = TextUnit(value = 24f, type = TextUnitType.Sp),
                fontWeight = FontWeight.W500,
                color = Color.White
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        modifier = Modifier.size(16.dp),
                        painter = painterResource(id = R.drawable.ic_distance),
                        contentDescription = "Distance",
                        tint = Color.Gray
                    )
                    Text(
                        modifier = Modifier.padding(start = 4.dp, end = 32.dp),
                        text = car.distance,
                        color = Color.White
                    )
                    Icon(
                        modifier = Modifier.size(16.dp),
                        painter = painterResource(id = R.drawable.ic_fuel),
                        contentDescription = "Fuel",
                        tint = Color.Gray
                    )
                    Text(
                        modifier = Modifier.padding(start = 4.dp, end = 16.dp),
                        text = car.fuel,
                        color = Color.White
                    )
                }
            }
        }
        Image(
            painter = painterResource(id = R.drawable.ic_next),
            contentDescription = "Next",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .padding(start = 16.dp)
        )
    }
    Divider(
        modifier = Modifier.padding(horizontal = 16.dp),
        color = colorResource(id = R.color.theme_grey)
    )
}

@Composable
fun MainScreen() {
    BoxWithConstraints {
        val screenHeight = maxHeight

        val firstAndThirdRowHeight = (234f / (234f + 170f + 234f)) * screenHeight.value
        val secondRowHeight = (170f / (234f + 170f + 234f)) * screenHeight.value

        Column(modifier = Modifier.fillMaxSize()) {
            TopBar()
            CarCard(
                car = Car(
                    imageResId = R.drawable.image_car_1, // Replace with your image resource
                    name = "Fortuner GR",
                    distance = "> 870km",
                    fuel = "50L",
                    price = "$4,500/hr"
                ),
                modifier = Modifier.height(firstAndThirdRowHeight.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(secondRowHeight.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                UserCard(
                    user = User(
                        imageResId = R.drawable.image_user, // Replace with your image resource
                        name = "Jane Cooper",
                        amount = "$4,253"
                    ),
                    modifier = Modifier.weight(1f)
                )
                MapCard(
                    modifier = Modifier.weight(1f)
                )
            }
            MoreCarsSection(
                cars = listOf(
                    Car(
                        imageResId = R.drawable.image_car_1, // Replace with your image resource
                        name = "Corolla Cross",
                        distance = "> 40km",
                        fuel = "50L",
                        price = null
                    ),
                    Car(
                        imageResId = R.drawable.image_car_1, // Replace with your image resource
                        name = "Ionic 5",
                        distance = "8 km",
                        fuel = "Full",
                        price = "$22"
                    )
                ),
                modifier = Modifier.height(firstAndThirdRowHeight.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}
