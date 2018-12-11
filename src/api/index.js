import {
  homeTeachers,
  homeStudents,
  homeCourse,
  homeLoop
} from "@/api/modules/home"

import {
  findTeacher,
} from "@/api/modules/TeacherDetails"

import {
  findStudent,
  findstuimg
} from "@/api/modules/StudentDetails"

import {
  killEndTime
} from "@/api/modules/Promotion"

import {
  AllCourse,
  Coursecatalogue,
  Coursedetails,
  Coursecomment,
} from "@/api/modules/Course"

import {
  ZeroCourse
} from "@/api/modules/ZeroExperience"

import {
  allOrder
} from "@/api/modules/MyOrder"

import {
  Getmycoupon,
  DetailUsername
} from "@/api/modules/personal"


export default {
  homeTeachers,
  homeStudents,
  homeCourse,
  homeLoop,
  findTeacher,
  findStudent,
  findstuimg,
  killEndTime,
  AllCourse,
  ZeroCourse,
  allOrder,
  Coursecatalogue,
  Coursecomment,
  Coursedetails,
  Getmycoupon,
  DetailUsername,
}