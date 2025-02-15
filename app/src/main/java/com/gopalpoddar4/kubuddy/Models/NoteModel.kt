package com.gopalpoddar4.kubuddy.Models

class NoteModel(
    var subjectName:String,
    var itemList: List<ChildModel>,
    var isExpanded:Boolean=false
    )