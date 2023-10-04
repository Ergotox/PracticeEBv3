package com.example.practiceebv3.ui.productdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.practiceebv3.data.local.AppDatabase
import com.example.practiceebv3.data.model.Product
import com.example.practiceebv3.repository.ProductRepository
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage


@Composable
fun ProductDetail(id: Int) {
    val context = LocalContext.current
    val productDao = AppDatabase.getInstance(context).productDao()
    val repository = ProductRepository(productDao)
    val hero = remember {
        mutableStateOf<Product?>(null)
    }
    repository.searchById(id = id) { result ->
        hero.value = result.data!!
    }

    if (hero.value != null) {

        Column {
            Spacer(modifier = Modifier.height(64.dp))
            ProductImage(hero.value!!.image.url)
            Spacer(modifier = Modifier.height(8.dp))
            ProductHeader(hero.value!!.title)
            Spacer(modifier = Modifier.height(8.dp))

        }

    }
}


@Composable
fun ProductImage(url: String) {
    GlideImage(
        imageModel = { url },
        imageOptions = ImageOptions(contentScale = ContentScale.Crop),
        modifier = Modifier
            .size(256.dp)
            .clip(shape = RoundedCornerShape(4.dp))
    )
}

@Composable
fun ProductHeader(name: String) {
    Text(
        text = name,
        style = MaterialTheme.typography.headlineMedium,
        fontWeight = FontWeight.Bold
    )

}

