package cu.my.practice.kmp.core.ui.xetid_ticket.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

/**
 * @param isErrorFixed whether the error spacer is placed even when there isn't error at all
 * */
@Composable
fun TicketTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    hint: String? = null,
    error: String? = null,
    isError: Boolean = false,
    isErrorFixed: Boolean = false,
    leadingIcon: ImageVector? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    capitalization: KeyboardCapitalization = KeyboardCapitalization.None,
    imeAction: ImeAction = ImeAction.Done,
    keyboardType: KeyboardType = KeyboardType.Text,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    maxLines: Int = 1,
    maxLength: Int = 35,
    isLengthVisible: Boolean = false,
    lines: Int = 1,
    readOnly: Boolean = false,
    placeholder: String = "",
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(),
    supportingText: String? = null,
) {
    OutlinedTextField(
        value = value,
        onValueChange = { newValue ->
            if (newValue.length <= maxLength) {
                onValueChange(newValue)
            }
        },
        modifier = modifier,
        label = hint?.let {
            {
                Text(
                    text = it,
                )
            }
        },
        maxLines = maxLines,
        minLines = lines,
        trailingIcon = if (error != null) {
            {
                Icon(
                    imageVector = Icons.Rounded.Warning,
                    contentDescription = "error icon",
                    tint = MaterialTheme.colorScheme.error
                )
            }
        } else trailingIcon,
        leadingIcon = leadingIcon?.let {
            { Icon(imageVector = it, contentDescription = null) }
        },
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions(
            capitalization = capitalization,
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = keyboardActions,
        supportingText = {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = when {
                        error !== null -> error
                        isErrorFixed -> ""
                        supportingText != null -> supportingText
                        else -> ""
                    },
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                )

                if (isLengthVisible) {
                    Text(
                        text = "${value.count()}/${maxLength}",
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                    )
                }
            }

//            error?.let {
//                Text(it)
//            } ?: if (isErrorFixed) {
//                Text(text = "")
//            } else if (isLengthVisible) {
//                Text(
//                    text = "${values.count()}/${maxLength}",
//                    textAlign = TextAlign.End,
//                    modifier = Modifier.fillMaxWidth()
//                )
//            } else supportingText?.let { it() }
        },
        isError = error != null || isError,
        readOnly = readOnly,
        enabled = !readOnly,
        placeholder = {
            if (placeholder.isNotBlank()) {
                Text(text = placeholder)
            }
        },
        colors = colors
    )
}

@Composable
fun TicketCheckBox(
    label: String,
    value: Boolean? = null,
    supportingText: String? = null,
    onValueChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {

    var checked = rememberSaveable { mutableStateOf(if (value != null) value else false) }

    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .padding(top = 5.dp)
                .border(
                    width = 1.dp,
                    color = OutlinedTextFieldDefaults.colors().disabledPlaceholderColor,
                    shape = OutlinedTextFieldDefaults.shape
                )
                .background(MaterialTheme.colorScheme.background)
                .clickable(
                    enabled = true,
                    onClick = {
                        checked.value = checked.value.not()
                        onValueChange(checked.value)
                    }
                ),

            ) {
            Text(
                text = label,
                modifier = Modifier.padding(16.dp)
            )
            Checkbox(
                checked = checked.value,
                onCheckedChange = {
                    checked.value = it
                    onValueChange(checked.value)
                }
            )
        }
        Row {
            Text(
                text = supportingText ?: "",
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
            )
        }
    }
}
