package com.example.mycalculator


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun Background(viewModel:  BackendCalculator, modifier: Modifier = Modifier){
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(15.dp)
    ){
        DisplayBox(viewModel)
        Layout(viewModel)
    }
}

@Composable
fun DisplayBox(viewModel: BackendCalculator, modifier: Modifier = Modifier) {
    val displayText = viewModel.displayText.value

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0x00FFFFFF))
                .padding(16.dp),
            contentAlignment = Alignment.BottomEnd // like a calculator display
        ) {
            Text(
                text = displayText,
                color = Color.Black,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )
        }

    }
}


@Composable
fun Layout(viewModel: BackendCalculator, modifier : Modifier = Modifier){
    Column(

    ) {
        Row(

        ) {
            Spacer(modifier = modifier.width(4.dp))
            Box(
                modifier = modifier
                    .clickable{
                        viewModel.clear()
                    }
                    .height(80.dp)
                    .width(85.dp)
                    .background(Color(0xFFFF0000), shape = RoundedCornerShape(12.dp)),
                    contentAlignment = Alignment.Center

            ){
                //
                Text(
                    "C",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = modifier.width(4.dp))
            Box(
                modifier = modifier
                    .clickable{
                        viewModel.onInput("%")
                    }
                    .height(80.dp)
                    .width(85.dp)
                    .background(Color(0xFFF39898),
                        shape = RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ){
                //
                Text(
                    "%",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = modifier.width(4.dp))
            Box(
                modifier = modifier
                    .clickable{
                        viewModel.onInput("-")
                    }
                    .height(80.dp)
                    .width(85.dp)
                    .background(Color(0xFFF39898),
                        shape = RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ){
                //
                Text(
                    "-",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = modifier.width(4.dp))
            Box(
                modifier = modifier
                    .clickable{
                        viewModel.backspace()
                    }
                    .height(80.dp)
                    .width(85.dp)
                    .background(Color(0xFFF39898), shape = RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ){
                //
                Image(
                    painter = painterResource(R.drawable.backspace),
                    "",
                )
            }
            //Row
        }

            Spacer(modifier = modifier.height(4.dp))
        Row(

        ) {
            Spacer(modifier = modifier.width(4.dp))
            Box(
                modifier = modifier
                    .clickable{
                        viewModel.onInput("1")
                    }
                    .height(80.dp)
                    .width(85.dp)
                    .background(Color(0xFFFFC107), shape = RoundedCornerShape(12.dp),)
                    .border(2.dp, color = Color.Black,
                        shape = RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ){
                //
                    Text(
                        "1",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )
            }
            Spacer(modifier = modifier.width(4.dp))
            Box(
                modifier = modifier
                    .clickable{
                        viewModel.onInput("2")
                    }
                    .height(80.dp)
                    .width(85.dp)
                    .background(Color(0xFFFFC107), shape = RoundedCornerShape(12.dp))
                    .border(2.dp, color = Color.Black,
                        shape = RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ){
                //
                Text(
                    "2",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = modifier.width(4.dp))
            Box(
                modifier = modifier
                    .clickable{
                        viewModel.onInput("3")
                    }
                    .height(80.dp)
                    .width(85.dp)
                    .background(Color(0xFFFFC107), shape = RoundedCornerShape(12.dp))
                    .border(2.dp, color = Color.Black,
                        shape = RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ){
                //
                Text(
                    "3",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = modifier.width(4.dp))
            Box(
                modifier = modifier
                    .clickable{
                        viewModel.onInput("/")
                    }
                    .height(80.dp)
                    .width(85.dp)
                    .background(Color(0xFFF39898), shape = RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ){
                //
                Text(
                    "/",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            //Row
        }

        Spacer(modifier = modifier.height(4.dp))
        Row(

        ) {
            Spacer(modifier = modifier.width(4.dp))
            Box(
                modifier = modifier
                    .clickable{
                        viewModel.onInput("4")
                    }
                    .height(80.dp)
                    .width(85.dp)
                    .background(Color(0xFFFFC107), shape = RoundedCornerShape(12.dp))
                    .border(2.dp, color = Color.Black, shape = RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ){
                //
                Text(
                    "4",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = modifier.width(4.dp))
            Box(
                modifier = modifier
                    .clickable{
                        viewModel.onInput("5")
                    }
                    .height(80.dp)
                    .width(85.dp)
                    .background(Color(0xFFFFC107), shape = RoundedCornerShape(12.dp))
                    .border(2.dp, color = Color.Black, shape = RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ){
                //
                Text(
                    "5",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = modifier.width(4.dp))
            Box(
                modifier = modifier
                    .clickable{
                        viewModel.onInput("6")
                    }
                    .height(80.dp)
                    .width(85.dp)
                    .background(Color(0xFFFFC107), shape = RoundedCornerShape(12.dp))
                    .border(2.dp, color = Color.Black, shape = RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ){
                //
                Text(
                    "6",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = modifier.width(4.dp))
            Box(
                modifier = modifier
                    .clickable{
                        viewModel.onInput("*")
                    }
                    .height(80.dp)
                    .width(85.dp)
                    .background(Color(0xFFF39898), shape = RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ){
                //
                Text(
                    "*",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            //Row
        }

        Spacer(modifier = modifier.height(4.dp))
        Row(

        ) {
            Spacer(modifier = modifier.width(4.dp))
            Box(
                modifier = modifier
                    .clickable{
                        viewModel.onInput("7")
                    }
                    .height(80.dp)
                    .width(85.dp)
                    .background(Color(0xFFFFC107), shape = RoundedCornerShape(12.dp))
                    .border(2.dp, color = Color.Black, shape = RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ){
                //
                Text(
                    "7",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = modifier.width(4.dp))
            Box(
                modifier = modifier
                    .clickable{
                        viewModel.onInput("8")
                    }
                    .height(80.dp)
                    .width(85.dp)
                    .background(Color(0xFFFFC107), shape = RoundedCornerShape(12.dp))
                    .border(2.dp, color = Color.Black, shape = RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ){
                //
                Text(
                    "8",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = modifier.width(4.dp))
            Box(
                modifier = modifier
                    .clickable{
                        viewModel.onInput("9")
                    }
                    .height(80.dp)
                    .width(85.dp)
                    .background(Color(0xFFFFC107), shape = RoundedCornerShape(12.dp))
                    .border(2.dp, color = Color.Black, shape = RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ){
                //
                Text(
                    "9",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = modifier.width(4.dp))
            Box(
                modifier = modifier
                    .clickable{
                        viewModel.onInput("+")
                    }
                    .height(80.dp)
                    .width(85.dp)
                    .background(Color(0xFFF39898), shape = RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ){
                //
                Text(
                    "+",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            //Row
        }

        Spacer(modifier = modifier.height(4.dp))
        Row(

        ) {
            Spacer(modifier = modifier.width(4.dp))
            Box(
                modifier = modifier
                    .clickable{
                        viewModel.onInput("00")
                    }
                    .height(80.dp)
                    .width(85.dp)
                    .background(Color(0xFF3F51B5), shape = RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ){
                //
                Text(
                    "00",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Spacer(modifier = modifier.width(4.dp))
            Box(
                modifier = modifier
                    .clickable{
                        viewModel.onInput("0")
                    }
                    .height(80.dp)
                    .width(85.dp)
                    .background(Color(0xFFFFC107), shape = RoundedCornerShape(12.dp))
                    .border(2.dp, color = Color.Black, shape = RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ){
                //
                Text(
                    "0",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = modifier.width(4.dp))
            Box(
                modifier = modifier
                    .clickable{
                        viewModel.onInput(".")
                    }
                    .height(80.dp)
                    .width(85.dp)
                    .background(Color(0xFF3F51B5), shape = RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ){
                //
                Text(
                    ".",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Spacer(modifier = modifier.width(4.dp))
            Box(
                modifier = modifier
                    .clickable{
                        viewModel.calculateResult()
                    }
                    .height(80.dp)
                    .width(85.dp)
                    .background(Color(0xFF4CAF50), shape = RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ){
                //
                Text(
                    "=",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            //Row
        }
        //Column
    }
    //main layout function
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ShowUI(){
    Background(BackendCalculator())
}