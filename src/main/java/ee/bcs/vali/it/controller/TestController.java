package ee.bcs.vali.it.controller;

import ee.bcs.vali.it.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    private final List<Employees> employees = new ArrayList();

    @GetMapping("fact")
    public int fact(@RequestParam("id") Integer sisend){
        return Lesson3.factorial(sisend);
    }

    @GetMapping("abs")
    public int abs(@RequestParam("id") Integer sisend){
        return Lesson1MathUtil.abs(sisend);
    }
    @GetMapping("sort")
    public int[] sort(@RequestParam("id") int[] sisend)
    {
        return Lesson3.sort(sisend);
    }
    @GetMapping("sirime")
    public boolean isPrime(@RequestParam("id") Integer sisend){
        return Lesson3.isPrime(sisend);
    }
    @GetMapping("fibo")
    public int fibonacci(@RequestParam("id") Integer sisend){
        return Lesson2.fibonacci(sisend);
    }
    @GetMapping("reverse")
    public String reverse(@RequestParam("id") String sisend){
        return Lesson3.reverseString(sisend);
    }
    @GetMapping("iseven")
    public boolean iseven(@RequestParam("id") Integer sisend){
        return Lesson1MathUtil.isEven(sisend);
    }
    @GetMapping("min")
    public int min(@RequestParam("id") Integer sisend){
        return Lesson1MathUtil.min(4,6,sisend);
    }
    @GetMapping("summa")
    public int summa(@RequestParam("id") Integer sisend){
        return Lesson3.sum(55,sisend);
    }
    @GetMapping("paaris")
    public int paaris(@RequestParam("id") Integer sisend){
        return Lesson2.exercise2(sisend);
    }
    @GetMapping("dto")
    public Auto dtoAuto(@RequestParam("aasta") int aasta, @RequestParam("mudel") String mudel,
                        @RequestParam("kindl") boolean kindlustus){
        Auto auto = new Auto();
        auto.setAasta(aasta);
        auto.setMudel(mudel);
        auto.setKindlustus(kindlustus);
        return auto;

    }
    @PostMapping("dto")
    public void dtoAuto(@RequestBody Auto auto){
        System.out.println(auto.getAasta());
        System.out.println(auto.getMudel());
        System.out.println(auto.isKindlustus());
    }
    @GetMapping("employee")
    public List<Employees> getAllEmployees(){
        return employees;
    }
    @PostMapping("employee")
    public void addEmployee(@RequestBody Employees sisend){
        employees.add(sisend);
    }
    @GetMapping("employee/{id}")
    public Employees getIdEmployee(@PathVariable("id") int sisend){
        return employees.get(sisend);
    }
    @PutMapping("employee/{id}")
    public void putIdEmployee(@RequestBody Employees töötaja, @PathVariable("id") int sisend){
        employees.set(sisend, töötaja);
    }
    @DeleteMapping("employee/{id}")
    public void deleteEmployee(@PathVariable("id") int sisend){
        employees.remove(sisend);
    }
}
