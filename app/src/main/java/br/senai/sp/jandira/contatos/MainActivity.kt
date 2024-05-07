package br.senai.sp.jandira.contatos

import TelaCadastro
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.contatos.screens.TelaHome
import br.senai.sp.jandira.contatos.ui.theme.ContatosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContatosTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFFAFAFA)
                ) {

                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "home"
                    ){
                        composable(route = "home"){ TelaHome(navController)}
                        composable(route = "cadastro"){ TelaCadastro(navController)}
                    }

                }
            }
        }
    }
}
