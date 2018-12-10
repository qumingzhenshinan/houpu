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
  AllCourse
} from "@/api/modules/Course"

import {
  ZeroCourse
} from "@/api/modules/ZeroExperience"

import {
  Coursecatalogue
} from "@/api/modules/Course"

import {
  Coursecomment
} from "@/api/modules/Course"

import {
  Coursedetails
} from "@/api/modules/Course"

import {
  allOrder
} from "@/api/modules/MyOrder"

import {
  Getmycoupon
} from "@/api/modules/personal"

import {
  findExamAll,
  findExamOnly
} from "@/api/modules/exam"

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
  findExamAll,
  findExamOnly,
}