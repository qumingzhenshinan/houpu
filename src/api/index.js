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
  SubjectQuery,
} from "@/api/modules/Course"

import {
  ZeroCourse,
  NewCourse
} from "@/api/modules/ZeroExperience"

import {
  allOrder
} from "@/api/modules/MyOrder"

import {
  Getmycoupon,
  DetailUsername,
  GetPhonenum,
  ExamHistoy,
  ChangePassword,
  UpdataImg,
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
  DetailUsername,
  findExamAll,
  findExamOnly,
  SubjectQuery,
  GetPhonenum,
  NewCourse,
  ExamHistoy,
  ChangePassword,
  UpdataImg,
}