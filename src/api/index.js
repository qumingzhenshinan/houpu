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
  findCourse,
  getrecommendedC
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

import {
  findExamAll,
  findExamOnly,
  getAnswer
} from "@/api/modules/exam"

import {
  getPhoneC,
  reMCUser,
  getlogin
} from "@/api/modules/start"


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
  findExamAll,
  findExamOnly,
  findCourse,
  getPhoneC,
  reMCUser,
  getlogin,
  getAnswer,
  getrecommendedC

}