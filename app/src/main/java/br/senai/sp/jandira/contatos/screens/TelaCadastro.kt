import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.contatos.R
import br.senai.sp.jandira.contatos.model.Contato
import br.senai.sp.jandira.contatos.repository.ContatoRepository
import br.senai.sp.jandira.contatos.ui.theme.ContatosTheme

@Composable
fun TelaCadastro(navController: NavHostController) {

    //contato repository -> passa o contexto
    val cr = ContatoRepository(LocalContext.current)


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
    var nameErrorState = remember {
        mutableStateOf(false)
    }

    Column () {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row (
                modifier = Modifier.fillMaxWidth().background(Color.Black),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.clickable { navController.navigate("home") }.padding(10.dp),
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Voltar",
                    tint = Color.Magenta
                )
                Spacer(modifier = Modifier.width(50.dp))
                Text(
                    text = stringResource(id = R.string.new_contact),
                    fontSize = 32.sp,
                    fontWeight =  FontWeight.Bold,
                    color = Color.Magenta,
                    modifier = Modifier.padding(10.dp)
                )
            }

            Spacer(modifier = Modifier.height(32.dp))
            OutlinedTextField(
                value = nameState.value,
                onValueChange = {
                    nameState.value = it
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Magenta,
                    focusedTextColor = Color(0xff6d0373),
                    focusedLabelColor = Color.Magenta,
                    errorBorderColor = Color.Red
                ),
                modifier = Modifier
                    .fillMaxWidth(),
                label = {
                    Text(
                        text = stringResource(id = R.string.contact_name)
                    )
                },
                isError = nameErrorState.value
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
                onClick = {
                    //criar um objeto contato

                    if(nameState.value == "" || emailState.value == ""){
                        nameErrorState.value = true
                    }else{
                        val contato = Contato(
                            nome = nameState.value,
                            email = emailState.value,
                            telefone = phoneState.value,
                            dataNascimento = birthdayState.value,
                            isFamilia = familyState.value
                        )
                        //chamar a instância do repositório e a função de salvar o contato, mandando as informações do contato
                        cr.salvar(contato)
                        navController.navigate("home")
                    }

                },
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

