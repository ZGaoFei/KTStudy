package com.example.ktstudy.list

abstract class Data

data class ItemData(val title: String, val content: String) : Data()

data class Item2Data(val title: String) : Data()