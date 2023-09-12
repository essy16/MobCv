package com.essycynthia.mobcv

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.essycynthia.mobcv.ui.theme.util.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CvScreen(
    navController: NavController,
    viewModel: CvViewModel
) {
    val fullNames = viewModel.fullNames.value
    val slackUserName = viewModel.slackUserName.value
    val githubHandle = viewModel.githubHandle.value
    val bio = viewModel.personalBio.value
    Column {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.width(80.dp))

            Button(onClick = { navController.navigate(Screen.EditableScreen.route) }) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = stringResource(id = R.string.edit_cv))

            }
        }

        Column {
            Row(
                Modifier
                    .background(color = Color.Magenta)
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp, vertical = 8.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.my_names),
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
            }
            Row (Modifier.padding(horizontal = 8.dp)){
                Text(text = "$fullNames")
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        Column {
            Row(
                Modifier
                    .background(color = Color.Magenta)
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp, vertical = 8.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.my_slack_username),
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
            }
            Row (Modifier.padding(horizontal = 8.dp)){
                Text(text = "$slackUserName")
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        Column {
            Row(
                Modifier
                    .background(color = Color.Magenta)
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp, vertical = 8.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.my_github),
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
            }

            Row (Modifier.padding(horizontal = 8.dp)){
                Text(text = "$githubHandle")
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        Column {
            Row(
                Modifier
                    .background(color = Color.Magenta)
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp, vertical = 8.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.my_bio),
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
            }
            Row (Modifier.padding(horizontal = 8.dp)){
                Text(text = "$bio")
            }
        }
    }
}