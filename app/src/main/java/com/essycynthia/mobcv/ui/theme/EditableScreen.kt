package com.essycynthia.mobcv.ui.theme

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.essycynthia.mobcv.CvViewModel
import com.essycynthia.mobcv.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditableScreen(
    navController: NavController,
    viewModel: CvViewModel,

    ) {
    var fullNamesTextFieldValue by remember { mutableStateOf(viewModel.fullNames.value) }
    var slackUserNameTextFieldValue by remember { mutableStateOf(viewModel.slackUserName.value) }
    var githubHandleTextFieldValue by remember { mutableStateOf(viewModel.githubHandle.value) }
    var bioTextFieldValue by remember { mutableStateOf(viewModel.personalBio.value) }
    var hasChanges by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }
    var confirmChanges by remember { mutableStateOf(false) }


    BackHandler {
        if (hasChanges) {
            // Show a confirmation dialog
            showDialog = true
            if (confirmChanges) {
                // User confirmed the changes, popBackStack
                navController.popBackStack()
            }


        } else {
            // If no changes, just popBackStack
            navController.popBackStack()
        }
    }


    Column(Modifier.fillMaxSize()) {
        TextField(
            value = fullNamesTextFieldValue!!,
            onValueChange = {
                fullNamesTextFieldValue = it
                viewModel.updateName(it)
                hasChanges = true
            },
            label = { Text(stringResource(id = R.string.enter_full_names)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 20.dp)
        )
        TextField(
            value = slackUserNameTextFieldValue!!,
            onValueChange = {
                slackUserNameTextFieldValue = it
                viewModel.updateSlackUserName(it)
                hasChanges = true
            },
            label = { Text(stringResource(id = R.string.enter_slack_username)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 20.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = githubHandleTextFieldValue!!,
            onValueChange = {
                githubHandleTextFieldValue = it
                viewModel.updateGithubHandle(it)
                hasChanges = true
            },
            label = { Text(stringResource(id = R.string.enter_github_url)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 20.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = bioTextFieldValue!!,
            onValueChange = {
                bioTextFieldValue = it
                viewModel.updatePersonalBio(it)
                hasChanges = true
            },
            label = { Text(stringResource(id = R.string.describe_yourself)) },
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            navController.popBackStack()
        },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)) {
            Text(text = stringResource(id = R.string.save))
        }
    }
    if (showDialog) {
        ShowDialogToDiscardChanges(navController) {
            showDialog = false
            if (confirmChanges) {
                navController.popBackStack()
            }
        }
    }
}


@Composable
fun ShowDialogToDiscardChanges(
    navController: NavController,
    onCloseDialog: () -> Unit
) {

    AlertDialog(
        onDismissRequest = {
            onCloseDialog()
        },
        title = { Text("Discard Changes?") },
        text = { Text("Do you want to discard changes?") },
        confirmButton = {
            TextButton(
                onClick = {
                    navController.popBackStack()
                    onCloseDialog()


                }
            ) {
                Text("Discard")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    // Dismiss the dialog
                    onCloseDialog()
                }
            ) {
                Text("Cancel")
            }
        }
    )
}
