package br.senai.sp.jandira.contatos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.contatos.ui.theme.ContatosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContatosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFFAFAFA)
                ) {
                    FormularioCadastro()
                }
            }
        }
    }
}

@Composable
fun FormularioCadastro() {

    var nameState = remember {
        mutableStateOf("")
    }
    var phoneState = remember {
        mutableStateOf("")
    }
    var emailState = remember {
        mutableStateOf("")
    }
    var birthdayState = remember {
        mutableStateOf("")
    }
    var familyState = remember {
        mutableStateOf(false)
    }

    Column () {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.title),
                fontSize = 32.sp,
                fontWeight =  FontWeight.Bold,
                color = Color.Magenta
            )
            Spacer(modifier = Modifier.height(32.dp))
            OutlinedTextField(
                value = nameState.value,
                onValueChange = {
                    nameState.value = it
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Magenta,
                    focusedTextColor = Color(0xff6d0373),
                    focusedLabelColor = Color.Magenta
                ),
                modifier = Modifier
                    .fillMaxWidth(),
                label = {
                    Text(
                        text = stringResource(id = R.string.contact_name)
                    )
                }
            )
            OutlinedTextField(
                value = phoneState.value,
                onValueChange = {
                    phoneState.value = it
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Magenta,
                    focusedTextColor = Color(0xff6d0373),
                    focusedLabelColor = Color.Magenta
                ),
                modifier = Modifier
                    .fillMaxWidth(),
                label = {
                    Text(
                        text = stringResource(id = R.string.contact_phone)
                    )
                }
            )
            OutlinedTextField(
                value = emailState.value,
                onValueChange = {
                    emailState.value = it
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Magenta,
                    focusedTextColor = Color(0xff6d0373),
                    focusedLabelColor = Color.Magenta
                ),
                modifier = Modifier
                    .fillMaxWidth(),
                label = {
                    Text(
                        text = stringResource(id = R.string.contact_email)
                    )
                }
            )
            OutlinedTextField(
                value = birthdayState.value,
                onValueChange = {
                    birthdayState.value = it
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Magenta,
                    focusedTextColor = Color(0xff6d0373),
                    focusedLabelColor = Color.Magenta
                ),
                modifier = Modifier
                    .fillMaxWidth(),
                label = {
                    Text(
                        text = stringResource(id = R.string.contact_birthday)
                    )
                }
            )
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Checkbox(
                    checked = familyState.value,
                    onCheckedChange = {
                        familyState.value = it
                    },
                    colors = CheckboxDefaults.colors(
                        checkmarkColor = Color.Magenta,
                        checkedColor = Color.White
                    )
                )
                Text(text = stringResource(id = R.string.family))
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Magenta
                )
            ){
                Text(
                    text = stringResource(id = R.string.save),
                    fontSize = 18.sp
                )
            }


        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FormularioCadastroPreview() {
    ContatosTheme {
        FormularioCadastro()
    }
}