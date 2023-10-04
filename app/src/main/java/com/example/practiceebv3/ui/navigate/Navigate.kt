package com.example.practiceebv3.ui.navigate

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.practiceebv3.ui.productdetail.ProductDetail
import com.example.practiceebv3.ui.productlist.Search

@Composable
fun Navigate(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.Search.route){
        composable(Routes.Search.route){
            Search(){id->
                navController.navigate("${Routes.Detail.route}/$id")
            }
        }
        composable(
            route = Routes.Detail.routeWithArgument,
            arguments = listOf(navArgument(Routes.Detail.argument){type = NavType.StringType})
        ){backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") as Int
            ProductDetail(id)
        }
    }
}
sealed class Routes(val route:String){
    object Search : Routes("ProductSearch")
    object Detail : Routes("ProductDetail"){
        const val routeWithArgument = "´ProductDetail/{id}"
        const val argument = "id"
    }
}