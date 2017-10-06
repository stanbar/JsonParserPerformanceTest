package com.stasbar.jsontests

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.stasbar.jsontests.models.*
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    val REPEAT = 10
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        System.gc()
        val time1 = measureTimeMillis { method1() }
        println("Method 1 took $time1 ms")

        System.gc()
        val time2 = measureTimeMillis { method2() }
        println("Method 2 took $time2 ms")

        System.gc()
        val time3 = measureTimeMillis { method3() }
        println("Method 2 took $time3 ms")


    }

    private fun method1() {

        val rawData = RawAsset.getData1(this)
        repeat(REPEAT) {
            val data = Gson().fromJson(rawData, Test1::class.java)

            val downloads = ArrayList<ItemTest>()
            with(data.listDownload[0]) {
                val kadrs = Kadr.split(",").map { it.toFloat() }
                val ids = ListaId.split(",").map { it.toInt() }
                val contents = tresc.split(",")
                val xs = XY.split(",").map { it.split("x")[0].toInt() }
                val ys = XY.split(",").map { it.split("x")[1].toInt() }
                repeat(kadrs.size) {
                    val item = ItemTest(id = ids[it], tresc = contents[it], f = kadrs[it], w = xs[it], h = ys[it])
                    downloads.add(item)
                }
            }
            val new = ArrayList<ItemTest>()
            with(data.listNew[0]) {
                val kadrs = Kadr.split(",").map { it.toFloat() }
                val ids = ListaId.split(",").map { it.toInt() }
                val contents = tresc.split(",")
                val xs = XY.split(",").map { it.split("x")[0].toInt() }
                val ys = XY.split(",").map { it.split("x")[1].toInt() }
                repeat(kadrs.size) {
                    val item = ItemTest(id = ids[it], tresc = contents[it], f = kadrs[it], w = xs[it], h = ys[it])
                    new.add(item)
                }
            }

            val likes = ArrayList<ItemTest>()
            with(data.listLike[0]) {
                val kadrs = Kadr.split(",").map { it.toFloat() }
                val ids = ListaId.split(",").map { it.toInt() }
                val contents = tresc.split(",")
                val xs = XY.split(",").map { it.split("x")[0].toInt() }
                val ys = XY.split(",").map { it.split("x")[1].toInt() }
                repeat(kadrs.size) {
                    val item = ItemTest(id = ids[it], tresc = contents[it], f = kadrs[it], w = xs[it], h = ys[it])
                    likes.add(item)
                }
            }
        }

    }

    private fun method2() {
        val rawData = RawAsset.getData2(this)
        repeat(REPEAT) {
            val data = Gson().fromJson(rawData, Test2::class.java)
            
            val downloads = ArrayList<ItemTest>()
            repeat(data.download_kadr.size) {
                val item = ItemTest(id = data.download_ListaId[it], tresc = data.download_tresc[it]
                        , f = data.download_kadr[it], w = data.download_X[it], h = data.download_Y[it])
                downloads.add(item)
            }

            val likes = ArrayList<ItemTest>()
            repeat(data.like_kadr.size) {
                val item = ItemTest(id = data.like_ListaId[it], tresc = data.like_tresc[it]
                        , f = data.like_kadr[it], w = data.like_X[it], h = data.like_Y[it])
                likes.add(item)
            }


            val news = ArrayList<ItemTest>()
            repeat(data.new_kadr.size) {
                val item = ItemTest(id = data.new_ListaId[it], tresc = data.new_tresc[it]
                        , f = data.new_kadr[it], w = data.new_X[it], h = data.new_Y[it])
                news.add(item)
            }
        }
    }

    private fun method3() {
        val rawData = RawAsset.getData3(this)
        repeat(REPEAT) {
            val data = Gson().fromJson(rawData, Test3::class.java)
            val downloads = data.items_download
            val likes = data.items_like
            val news = data.items_new
        }
    }
}
