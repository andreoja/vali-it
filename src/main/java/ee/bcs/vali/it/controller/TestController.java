package ee.bcs.vali.it.controller;

import ee.bcs.vali.it.Lesson1MathUtil;
import ee.bcs.vali.it.Lesson2;
import ee.bcs.vali.it.Lesson3;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("fact")
    public int fact(@RequestParam("id") Integer sisend){
        return Lesson3.factorial(sisend);
    }

    @GetMapping("abs")
    public int abs(@RequestParam("id") Integer sisend){
        return Lesson1MathUtil.abs(sisend);
    }
    @GetMapping("sort")
    public int[] sort(@RequestParam("id") int[] sisend){
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


}
