package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.klu.entity.Student;
import com.klu.model.StudentManager;

@RestController
@RequestMapping("/crud")
@ResponseBody
@CrossOrigin(origins = "http://localhost:5173/")
public class StudentController 
{
 @Autowired
 StudentManager sm;
 //http://localhost:8080/crud/insert
 @PostMapping("/insert")
 @ResponseBody
 public String insert(@RequestBody Student s2)
 {
  return sm.insertData(s2);
 }
 
 //http://localhost:8080/crud/alldata
 @GetMapping("/alldata")
 @ResponseBody
 public List<Student> getAllData()
 {
  return sm.getData();
 }
 
 
 //http://localhost:8080/crud/getbyid/1
 @GetMapping("/getbyid/{sid}")
 @ResponseBody
 public Student getbyId(@PathVariable Long sid)
 {
  return sm.getDataById(sid);
 }
 @PutMapping("/updateall/{sid}")
 @ResponseBody
 public String updateAllData(@PathVariable Long sid,@RequestBody Student s1)
 {
 return sm.updateData(sid, s1);
 }
 
 //http://localhost:8080/crud/updatename/1?sname=lucky
 @PatchMapping("/updatename/{sid}")
 @ResponseBody
 public String updateName(@PathVariable Long sid,@RequestParam String sname) {
	 return sm.updateByname(sid, sname);
 }
 
 //http://localhost:8080/crud/updatedept/1?sdept=ME
 @PatchMapping("/updatedept/{sid}")
 @ResponseBody
 public String updateDept(@PathVariable Long sid,@RequestParam String sdept) {
	 return sm.updateByDept(sid, sdept);
 }
 
 @DeleteMapping("/deleterecord/{sid}")
 @ResponseBody
 public String deleteData(@PathVariable Long sid) {
	 return sm.deleteData(sid);
 }

}