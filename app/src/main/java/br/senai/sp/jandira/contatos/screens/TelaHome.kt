package br.senai.sp.jandira.contatos.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.twotone.AccountCircle
import androidx.compose.material.icons.twotone.Add
import androidx.compose.material.icons.twotone.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.contatos.R
import br.senai.sp.jandira.contatos.repository.ContatoRepository
import br.senai.sp.jandira.contatos.ui.theme.ContatosTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaHome(navController: NavHostController) {

    val cr = ContatoRepository(LocalContext.current)
    val contatos = cr.buscarTodosOsContatos()

    Scaffold (
        topBar = {
            TopAppBar(
                navigationIcon = {
                    Icon(
                        modifier = Modifier.padding(18.dp),
                        imageVector = Icons.Outlined.ArrowBack,
                        contentDescription = "Ícone de casa",
                        tint = Color.Magenta
                    )
                },
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(id = R.string.title),
                        textAlign = TextAlign.Center,
                        color = Color.Magenta
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black
                ),
                actions = {
                    Icon(
                        modifier = Modifier.padding(18.dp),
                        imageVector = Icons.TwoTone.AccountCircle ,
                        contentDescription = "Ícone de usuário",
                        tint = Color.Magenta
                    )
                }

            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("cadastro")
                },
                containerColor = Color.Magenta,
                shape = CircleShape
            ) {
                Icon(Icons.TwoTone.Add, contentDescription = "", tint = Color.Black)
            }
        }
    ){innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        )
        {
            LazyColumn (
                modifier = Modifier
                    .fillMaxWidth(),
                contentPadding = PaddingValues(12.dp)
            ) {
                items(contatos){
                    Card (
                        modifier = Modifier
                            .height(140.dp)
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Black
                        ),
                        border = BorderStroke(1.dp, Color.Magenta)
                    ){
                        Row(
                            modifier = Modifier
                                .padding(24.dp)
                                .fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Card (
                                modifier = Modifier
                                    .size(60.dp),
                                shape = CircleShape,
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.White
                                ),
                                border = BorderStroke(2.dp, Color.Magenta)
                            ) {
                               Row (
                                   modifier = Modifier.fillMaxSize(),
                                   verticalAlignment = Alignment.CenterVertically,
                                   horizontalArrangement = Arrangement.Center
                               ){
                                   Text(
                                       text = it.nome.substring(0..0),
                                       fontSize = 32.sp,
                                       color = Color.Magenta
                                   )
                               }
                            }
                            Column (
                                modifier = Modifier.padding(horizontal = 16.dp)
                            ){
                                Row (
                                    verticalAlignment = Alignment.CenterVertically
                                ){
                                    Text(
                                        text = it.nome,
                                        color = Color.White,
                                        fontSize = 20.sp
                                    )
                                    if(it.isFamilia){
                                        Icon(
                                            imageVector = Icons.TwoTone.Favorite,
                                            contentDescription = "Coração",
                                            tint = Color.Magenta,
                                            modifier = Modifier.height(20.dp).padding(horizontal = 10.dp)
                                        )
                                    }
                                }
                                Text(
                                    text = it.email,
                                    color = Color.White
                                )
                            }

                        }

                    }
                }

            }
        }
    }
}

//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun TelaHomePreview() {
//    ContatosTheme {
//        TelaHome(navController)
//    }
//}