import MyClasses.*;

public class Program {
    public static void main(String[] args) {

        //#region Task_1
        /*Создайте класс Human, который будет содержать информацию о человеке.
        С помощью механизма наследования, реализуйте класс Builder (содержит информацию о строителе),
        класс Sailor(содержит информацию о моряке), класс Pilot (содержит информацию о летчике).
        Каждый из классов должен содержать необходимые для работы методы.*/

        Human pilot = new Pilot("Jason", "australian", 37, "pilot");
        Human builder = new Builder("Nicole", "italian", 41, "builder");
        Human sailor = new Sailor("Jack", "american", 31, "sailor");

        /*System.out.println(pilot);
        System.out.println(builder);
        System.out.println(sailor);*/

        //#endregion

        //#region Task_2
        /*Создать базовый класс «Животное» и производные классы «Тигр», «Крокодил», «Кенгуру».
         С помощью конструктора установить имя каждого животного и его характеристики.
         Создайте для каждого класса необходимые методы и поля*/

        Animal kengaroo = new Kengaroo();
        Animal crocodale = new Crocodale();
        Animal tiger = new Tiger();

        /*System.out.println(kengaroo);
        System.out.println(crocodale);
        System.out.println(tiger);*/

        //#endregion

        //#region Task_3
        /*Запрограммируйте класс Money (объект класса оперирует одной валютой) для работы с деньгами.
        В классе должны быть предусмотрены поле для хране-ния целой части денег (доллары, евро, гривны и т.д.)
        и поле для хранения копеек (центы, евроценты, копейки и т.д.).Реализовать методы для вывода суммы на экран,
        за-дания значений для частей. На базе класса Money создать класс Product для работы с продуктом или товаром.
        Реализовать метод, позволяю-щий уменьшить цену на заданное число.
        Для каждого из классов реализовать необходимые методы и поля*/

        Product product = new Product("Bread", new Money(12,1,1,15,1,1));
        Money sum = new Money(4,1,1,10,1,1);
        product.ChangePrice(sum);
        //System.out.println(product);

        //#endregion

        //#region Task_4
        /*Создать базовый класс «Устройство» и производные классы «Чайник», «Микроволновка», «Автомобиль», «Пароход».
        С помощью конструктора установить имя каждого устройства и его характеристики.
        Реализуйте для каждого из классов методы:
            ■  Sound — издает звук устройства (пишем текстом в консоль);
            ■  Show — отображает название устройства;
            ■  Desc — отображает описание устройства*/

            Device [] devices = new Device[] {new Kettle(), new Microwave(), new Car(), new Steamer()};

            /*for (int i=0; i<devices.length;i++){
                devices[i].Show();
                devices[i].Sound();
                devices[i].Desc();
                System.out.println();
            }*/

        //#endregion

        //#region Task_5
        /*Создать базовый класс «Музыкальный инструмент» и производные классы «Скрипка», «Тромбон», «Укулеле», «Виолончель».
        С помощью конструктора установить имя каждого музыкального инструмента и его характеристики.
        Реализуйте для каждого из классов методы:
            ■  Sound — издает звук музыкального инструмента (пишем текстом в консоль);
            ■  Show — отображает название музыкального инстру-мента;
            ■  Desc — отображает описание музыкального инстру-мента;
            ■  History — отображает историю создания музыкального инструмента*/

            MusicalInstrument[] musicalInstruments = new MusicalInstrument[]{new Cello(),new Trombone(), new Violin(), new Ukulele()};

            /*for (int i=0;i<musicalInstruments.length;i++){
                musicalInstruments[i].Show();
                musicalInstruments[i].Sound();
                musicalInstruments[i].Desc();
                musicalInstruments[i].Histoty();
                System.out.println();
            }*/

        //#endregion

        //#region Task_6
        /*Создайте интерфейс IMath. В нём должно быть три метода:
            ■  int Max()  —  возвращает максимум;
            ■  int Min() — возвращает минимум;
            ■  float Avg() — возвращает среднеарифметическое.
       Класс Array, созданный ранее, должен имплементировать интерфейс IMath.
       Метод Max — возвращает максимум среди элементов массива.
       Метод Min — возвращает минимум среди элементов массива*/

        MyArray arr = new MyArray(5);
        arr.FillArr(-5,20);
       // arr.Show();
        //System.out.println();

        //System.out.printf("max: %s, min: %s, avg: %s ", arr.Max(), arr.Min(), arr.Avg());
        //System.out.println();


        //#endregion

        //#region Task_7
        /*Создайте интерфейс ISort. В нём должно быть два метода:
            ■  void SortAsc() — сортировка по возрастанию;
            ■  void SortDesc() — сортировка по убыванию.
        Класс Array, созданный ранее, должен имплементировать интерфейс ISort.
        Метод SortAsc — сортирует массив по возрастанию.
        Метод SortDesc — сортирует массив по убыванию.
        Напишите код для тестирования полученной функ-циональности*/

        arr.Show();
        System.out.println();

        System.out.println("Sort asc( сортировка по возрастанию): ");
        arr.SortAsc();
        arr.Show();
        System.out.println();

        System.out.println("Sort desc( сортировка по убыванию): ");
        arr.SortDesc();
        arr.Show();
        System.out.println();

        //#endregion
    }
}
