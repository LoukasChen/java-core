package com.csp.mapstruct;

/**
 * @desc:
 * @author: csp52872
 * @date: 2022/5/8
 */
public class JavaBeanConvert {

    public static void main(String[] args) {
        Car car = new Car();
        car.setMake("make");
        car.setType(2);
        car.setNumberOfSeats(1);
        CarDTO carDTO = CarMapper.INSTANCE.carToCarDTO(car);
        System.out.println(carDTO);
    }
}
