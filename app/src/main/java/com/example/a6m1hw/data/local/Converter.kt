package com.example.a6m1hw.data.local

import androidx.room.TypeConverter
import com.example.a6m1hw.model.Item
import com.example.a6m1hw.model.PageInfo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

object Converter {

    val gson = Gson()

    @TypeConverter
    fun gsonToItems(data:String?): List<Item> {
        val listType: Type =object :TypeToken<List<Item>>(){}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun itemsToString(items: List<Item>): String {
        return gson.toJson(items)
    }

    @TypeConverter
    fun pageInfoToString(pageInfo: PageInfo): String {
        return gson.toJson(pageInfo)
    }

    @TypeConverter
    fun gsonToPageInfo(data:String?): PageInfo{
        return gson.fromJson(data, PageInfo::class.java)
    }
}