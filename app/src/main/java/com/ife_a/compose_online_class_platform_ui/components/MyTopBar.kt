package com.ife_a.compose_online_class_platform_ui.components

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ife_a.compose_online_class_platform_ui.ui.theme.*

@Preview(name = "Top bar", widthDp = 300)
@Composable
fun MyTopBar(
    name: String = "Jack"
) {
    var _searchValue by remember { mutableStateOf("") }

    AppTheme {
        Surface(
            color = MaterialTheme.colors.primary,
            shape = Shapes.large,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 10.dp, top = 30.dp, end = 10.dp, bottom = 20.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 0.dp, top = 0.dp, end = 0.dp, bottom = 30.dp)

                ) {
                    Column() {
                        Text(text = "Hi, $name ✋")
                        Text(text = "Let's start learning!")
                    }
                    IconButton(icon = Icons.Outlined.Notifications)
                }
                SearchBar(searchValue = _searchValue) { _searchValue = it }
//            SearchBarBasic(searchValue = _searchValue) { _searchValue = it }
            }
        }

    }
}

//@Preview(name = "Search bar", widthDp = 300)
@Composable
fun SearchBar(
    placeholder: String = "Search for anything",
    searchValue: String = "",
    onValueChange: (String) -> Unit = {}
) {

    val context = LocalContext.current

    AppTheme {
        Surface(
            color = md_theme_light_onPrimary,
            shape = Shapes.large,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = searchValue,
                    colors = TextFieldDefaults.textFieldColors(textColor = md_theme_light_secondary),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Search,
                            contentDescription = "",
                            modifier = Modifier.width(50.dp)
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = onValueChange,
                    placeholder = { Text(placeholder) },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Search
                    ),
                    keyboardActions = KeyboardActions(
                        onSearch = {
                            Toast.makeText(
                                context,
                                "Searched for $searchValue",
                                Toast.LENGTH_SHORT
                            ).show()
                        })
                )
            }
        }
    }
}


/**
 * Issues:
 * - Cannot get modifier focus listener to work.
 */
@Preview(name = "Search bar with basic text field", widthDp = 300)
@Composable
fun SearchBarBasic(
    placeholder: String = "Search for anything",
    searchValue: String = "",
    onValueChange: (String) -> Unit = {}
) {

    val placeHolderText by rememberSaveable { mutableStateOf(placeholder) }

    AppTheme {
        Surface(
            color = MaterialTheme.colors.background,
            shape = Shapes.large,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                BasicTextField(
                    value = searchValue,
                    onValueChange = onValueChange,
                    modifier = Modifier
                        .height(50.dp),
                    decorationBox = { innerTextField ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Search,
                                contentDescription = "",
                                tint = md_theme_light_secondary,
                                modifier = Modifier.width(50.dp)
                            )
                            if (searchValue.isEmpty()) {
                                Text(
                                    text = placeHolderText,
                                    color = md_theme_light_secondary,
                                    fontSize = 14.sp
                                )
                            }
                            innerTextField()
                        }
                    }
                )
            }
        }
    }
}

//@Preview(name = "Icon button", widthDp = 36)
@Composable
fun IconButton(
    icon: ImageVector = Icons.Outlined.Image,
    imageButtonClicked: () -> Unit = {}
) {
    Surface(
        color = md_theme_light_gray,
        shape = Shapes.medium,
        modifier = Modifier.size(36.dp)
    ) {
        Row() {
            IconButton(onClick = imageButtonClicked) {
                Icon(
                    imageVector = icon,
                    contentDescription = "",
                    tint = MaterialTheme.colors.onBackground
                )
            }
        }
    }
}