package com.example.lazyg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lazyg.ui.theme.LazyGTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyGTheme {
                CourseList(courses)
            }
        }
    }
}

val courses = listOf(
    Course("Dasar-Dasar Pemrograman", 3, R.drawable.logomk),
    Course("Bahasa Inggris", 2, R.drawable.logomk),
    Course("Bahasa Indonesia", 2, R.drawable.logomk),
    Course("Pendidikan Pancasila", 2, R.drawable.logomk),
    Course("Statistika dan Probabilitas", 3, R.drawable.logomk),
    Course("Kalkulus Differensial", 3, R.drawable.logomk),
    Course("Pengantar TIK", 2, R.drawable.logomk),
    Course("Matematika Diskrit", 3, R.drawable.logomk),
    Course("Kalkulus Integral", 3, R.drawable.logomk),
    Course("Pendidikan Agama Islam", 2, R.drawable.logomk),
    Course("Pendidikan Kewarganegaraan", 2, R.drawable.logomk),
    Course("Pengantar Sistem Digital", 3, R.drawable.logomk),
    Course("Struktur Data dan Algoritma", 3, R.drawable.logomk),
    Course("Aljabar Linier", 3, R.drawable.logomk),
    Course("Pengantar Teori Graph", 3, R.drawable.logomk),
    Course("Filsafat Matematika Dan Ilmu Pengetahuan Alam", 2, R.drawable.logomk),
)

@Composable
fun CourseItem(course: Course) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = course.imageResource),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .clip(shape = CircleShape)
        )
        Spacer(modifier = Modifier.width(19.dp))
        Column {
            Text(
                text = course.name,
                style = TextStyle(fontSize = 19.sp)
            )
            Text(
                text = "${course.sks} SKS",
                style = TextStyle(fontSize = 14.sp)
                )
        }
    }
}

@Composable
fun CourseList(course: List<Course>) {
    LazyColumn(
        content = {
            items(courses) { course ->
                CourseItem(course = course)
            }
        },
        verticalArrangement = Arrangement.spacedBy(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LazyGTheme {
       CourseList(courses)
    }
}