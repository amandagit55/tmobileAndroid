package com.example.composelist

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.composelist.model.Card


@Composable
fun ImageCard(
    card: Card,
    onClick: () -> Unit,
) {
    androidx.compose.material.Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                all = 16.dp
            )
            .fillMaxSize()
            .clickable(onClick = onClick)
    ) {
        Box(
            modifier = Modifier
                .height((card.card.image.size.height / LocalContext.current.resources.displayMetrics.density).dp)
        ) {


            loadImage(imageURL = card.card.image.url).value?.let {
                Image(
                    bitmap = it.asImageBitmap(),
                    contentScale = ContentScale.Crop,
                    contentDescription = card.card.description.value

                )

                Box(
                    modifier = Modifier.height((card.card.image.size.height / LocalContext.current.resources.displayMetrics.density).dp)
                ) {
                    Text(
                        text = card.card.title.value,
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(16.dp),
                        fontSize = card.card.title.attributes.font.size.sp,
                        color = Color.White,
                        fontWeight = Bold
                    )

                }
            }
        }
    }
}
@Composable
fun TextCard(
    card: Card,
    onClick: () -> Unit
) {
    androidx.compose.material.Card(
        modifier = Modifier
            .padding(
                all = 8.dp
            )
            .clickable(onClick = onClick)
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.small
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = card.card.title?.value ?: card.card.value,
                fontSize = (card.card.attributes?.font?.size
                    ?: card.card?.description?.attributes?.font?.size ?: 20).sp,
                fontWeight = Bold,
                modifier = Modifier.fillMaxWidth(0.85f)
            )
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun loadImage(imageURL: String): MutableState<Bitmap?> {

    val bitmapState: MutableState<Bitmap?> = mutableStateOf(null)
    Glide.with(LocalContext.current)
        .asBitmap()
        .load(imageURL)
        .into(object : CustomTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmapState.value = resource
            }
            override fun onLoadCleared(placeholder: Drawable?) {
            }
        })
    return bitmapState
}
