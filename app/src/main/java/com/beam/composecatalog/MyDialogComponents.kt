package com.beam.composecatalog

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.beam.composecatalog.ui.theme.Compose_catalogTheme

@Composable
fun MyCustomDialogGmailAccountChange(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(
            onDismissRequest = onDismiss,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(24.dp)
            ) {
                MyTitleDialog("Set backup account")
                MyAccountItem(email = "example_1@gmail.com", drawableRes = R.drawable.ic_launcher_background)
            }
        }
    }
}

@Composable
fun MyTitleDialog(text: String) {
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = Modifier.padding(bottom = 12.dp)
    )
}

@Composable
fun MyAccountItem(email: String, @DrawableRes drawableRes: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = drawableRes),
            contentDescription = "Profile photo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(
            text = email,
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun MyCustomDialog(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(
            onDismissRequest = onDismiss,
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(24.dp)
            ) {
                Text(text = "This i a example of a custom dialog")
            }
        }
    }
}

enum class AlertType {
    ALERT_DIALOG, CUSTOM_DIALOG, GMAIL_ACCOUNT_CHANGE_DIALOG
}

@Composable
fun MyTestDialog() {
    var show by rememberSaveable { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = { show = !show }) {
            Text(text = "Display AlertDialog")
        }
        val alertType = AlertType.GMAIL_ACCOUNT_CHANGE_DIALOG
        when (alertType) {
            AlertType.ALERT_DIALOG -> {
                MyAlertDialog(
                    show = show,
                    onConfirm = { Log.i("beam", "Alert dialog confirmed") },
                    onDismiss = { show = false }
                )
            }

            AlertType.CUSTOM_DIALOG -> {
                MyCustomDialog(show = show, onDismiss = { show = false })
            }

            AlertType.GMAIL_ACCOUNT_CHANGE_DIALOG -> {
                MyCustomDialogGmailAccountChange(show = show, onDismiss = { show = false })
            }
        }
    }
}

@Composable
fun MyAlertDialog(show: Boolean, onConfirm: () -> Unit, onDismiss: () -> Unit) {
    if (show) {
        AlertDialog(
            title = { Text(text = "Title") },
            text = { Text(text = "This is the content of the alert") },
            confirmButton = {
                TextButton(onClick = onConfirm) {
                    Text(text = "Confirm")
                }
            },
            dismissButton = {
                TextButton(onClick = onDismiss) {
                    Text(text = "Dismiss")
                }
            },
            onDismissRequest = onDismiss
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DialogComponentsDefaultPreview() {
    Compose_catalogTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            MyTestDialog()
        }
    }
}