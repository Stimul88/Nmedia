package ru.netology.nmedia

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.dto.Post

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        applyInsets(binding)

        binding.more


        val post = Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            published = "21 мая в 18:36",
            likes = 999,
            likedByMe = false,
            countShare = 1099,
            countEye = 1100
        )


        with(binding) {
            content.text = post.content
            author.text = post.author
            published.text = post.published
            countLike.text = countFunction(post.likes)
            countShare.text = countFunction(post.countShare)
            countEye.text = countFunction(post.countEye)

            heart.setOnClickListener {
                post.likedByMe = !post.likedByMe

                post.likes = if (post.likedByMe) {
                    post.likes + 1

                } else {
                    post.likes - 1
                }

                countLike.text = countFunction(post.likes)


                heart.setImageResource(
                    if(post.likedByMe) {
                        R.drawable.ic_heart_foreground_liked
                    } else {
                        R.drawable.ic_heart_foreground
                    }
                )
            }

            share.setOnClickListener {
                post.countShare += 1

                countShare.text = countFunction(post.countShare)
            }
        }
    }

    private fun applyInsets(binding: ActivityMainBinding) {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                v.paddingLeft + systemBars.left,
                v.paddingTop + systemBars.top,
                v.paddingRight + systemBars.right,
                v.bottom + systemBars.bottom
            )
            insets
        }
    }
}