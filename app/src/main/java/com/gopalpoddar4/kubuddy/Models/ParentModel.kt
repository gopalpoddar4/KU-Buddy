package com.gopalpoddar4.kubuddy.Models

class ParentModel(
    var subjectName:String,
    var itemList: List<ChildModel>,
    var isExpanded:Boolean=false
  )