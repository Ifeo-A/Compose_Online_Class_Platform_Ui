package com.ife_a.compose_online_class_platform_ui.components.searchBar

import android.widget.Toast
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ife_a.compose_online_class_platform_ui.ui.theme.AppTheme
import com.ife_a.compose_online_class_platform_ui.ui.theme.Shapes
import com.ife_a.compose_online_class_platform_ui.ui.theme.md_theme_light_onPrimary
import com.ife_a.compose_online_class_platform_ui.ui.theme.md_theme_light_secondary


@Preview(name = "Search bar", widthDp = 300)
@Composable
fun MySearchBar(
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
                    modifier = Modifier
                        .fillMaxWidth(),
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
fun MySearchBarBasic(
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