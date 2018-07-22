package bookshop.util.factory;

import java.util.Random;

/**
 * 
 * @author antonTkachenko
 *
 */

import bookshop.enteties.Author;

public class AuthorGenerator implements Generator<Author> {

	private final String[] firstNames = { "Авдей", "Аверкий", "Авксентий", "Агафон", "Александр", "Алексей", "Альберт",
			"Альвиан", "Анатолий", "Андрей", "Антон", "Антонин", "Анфим", "Аристарх", "Аркадий", "Арсений", "Артём",
			"Артур", "Архипп", "Афанасий", "Богдан", "Борис", "Вадим", "Валентин", "Валерий", "Валерьян", "Варлам",
			"Варфоломей", "Василий", "ВенедиктВениамин", "Викентий", "Виктор", "Виссарион", "Виталий", "Владимир",
			"Владислав", "Владлен", "Влас", "Всеволод", "Вячеслав", "Гавриил", "Галактион", "Геласий", "Геннадий",
			"Георгий", "Герасим", "Герман", "Глеб", "Гордей", "Григорий", "Даниил", "Демид", "Демьян", "Денис",
			"Дмитрий", "Добрыня", "Донат", "Дорофей", "Евгений", "Евграф", "Евдоким", "Евсей", "Евстафий", "Егор",
			"Емельян", "Еремей", "Ермолай", "Ефим", "Ждан", "Зиновий", "Иакинф", "Иван", "Игнатий", "Игорь", "Иларион",
			"Илья", "Иннокентий", "Ираклий", "Ириней", "Исидор", "Иулиан", "Касьян", "Ким", "Кирилл", "Климент",
			"Кондрат", "Константин", "Корнилий", "Кузьма", "Куприян", "Лаврентий", "Лев", "Леонид", "Леонтий", "Лука",
			"Лукий", "Лукьян", "Магистриан", "Макар", "Максим", "Марк", "Мартын", "Матвей", "Мелентий", "Мирон",
			"Мирослав", "Митрофан", "Михаил", "Мстислав", "Мэлор", "Назар", "Нестор", "Никанор", "Никита", "Никифор",
			"Николай", "Никон", "Олег", "Онисим", "Павел", "Пантелеймон", "Парфений", "Пётр", "Платон", "Порфирий",
			"Потап", "Прокопий", "Протасий", "Прохор", "Разумник", "Родион", "Роман", "Ростислав", "Руслан", "Савва",
			"Савелий", "Самуил", "Святополк", "Святослав", "Севастьян", "Семён", "Сергей", "Сильвестр", "Сильвестр",
			"Созон", "Спиридон", "Станислав", "Степан", "Тарас", "Тимофей", "Тимур", "Тихон", "Тихон", "Трифон",
			"Трофим", "Фаддей", "Фёдор", "Федосей", "Федот", "Феликс", "Феоктист", "Филат", "Филипп", "Фома", "Фрол",
			"Харитон", "Христофор", "Эдуард", "Эраст", "Юлиан", "Юрий", "Юстин", "Яков", "Якун", "Ярослав" };

	private final String[] lastNames = { "Шумейко", "Андрусейко", "Батейко", "Пилипейко", "Семочко", "Толочко",
			"Марочко", "Сирко", "Забужко", "Бутко", "Цушко", "Кличко", "Сасько", "Андрейко", "Коцюбинский",
			"Скоропадский", "Саксаганский", "Милославский", "Хованский", "Городецкий", "Острожский.Выговский",
			"Вальковский", "Котовский", "Петровский", "Масловский", "Барановский", "Яворивский", "Трублаевский",
			"Алчевский", "Миклашевский", "Гриневская", "Гребневский", "Шуфрич", "Зварыч", "Андрухович", "Шухевич",
			"Кобзар", "Житар", "Рымар", "Гончар", "Шугаев", "Паньков", "Шинкарёв", "Драгоманов", "Костомаров", "Хрущёв",
			"Брежнев", "Турчинов", "Пореченков", "Петренков", "Стецькив", "Петрив", "Иванив", "Павлив", "Федункив",
			"Палий", "Передрий", "Погомий", "Плаксий", "Повалий", "Червоний", "Многогрешный", "Мирный", "Правый",
			"Карпенко-Карый", "Навальный", "Яловой", "Яровой", "Лановой", "Бачей", "Гелетей", "Чухрай", "Бородай",
			"Тягай", "Щербак", "Хижняк", "Коровяк", "Худобяк", "Чумак", "Спивак", "Грабчак", "Петрик", "Павлик",
			"Бердник", "Пасичник", "Линник", "Колесник", "Медяник", "Хитрук", "Полищук", "Полещук", "Тарасюк", "Сердюк",
			"Яценюк", "Кравчук", "Корнейчук", "Гайчук", "Горобчук", "Ковальчук", "Коломоец", "Таранец", "Красинец",
			"Притула", "Гамула", "Шумило", "Трясило", "Шамрыло", "Мазайло", "Стегайло", "Предыбайло", "Посидайло",
			"Несвитайло", "Недбайло", "Шкраба", "Дзюба", "Чикольба", "Желиба", "Кулибаба", "Негода", "Майборода",
			"Легойда", "Лихно", "Махно", "Юхно", "Бажан", "Драган", "Жадан", "Василишен", "Никитишен", "Кондратишен",
			"Бондар", "Бортнык", "Гармаш", "Пушкар", "Грабар", "Гончар", "Гончаренко", "Гончарук", "Коваль",
			"Коваленко", "Ковальчук", "Колиснык", "Колисныченко", "Кравець", "Кравченко", "Кравчук", "Кушнир",
			"Кушниренко", "Кушнирук", "Кушнирчук", "Лифарь", "Мельнык", "Мельниченко", "Мельничук", "Овчаренко",
			"Олийнык", "Пасичнык", "Палий", "Писарчук", "Пономаренко", "Пономарчук", "Паламарчук", "Плахотнюк", "Рыбак",
			"Рыбалко", "Рымар", "Лымар", "Сердюк", "Скляр", "Скрынник", "Скрыпнык", "Слюсаренко", "Сопильняк", "Спивак",
			"Стельмах", "Стельмашенко", "Чумак", "Чумаченко", "Швець", "Шевчик", "Шевченко", "Шевчук", "Шинкарь",
			"Шинкаренко", "Шинкарук", "Баняк", "Брыль", "Доля", "Ковган", "Кошара", "Мороз", "Середа", "Телига", "Цвях",
			"Васюченко", "Герасименко", "Захарченко", "Захарко", "Клименко", "Клим", "Мартышин", "Михайленко",
			"Моисеенко", "Мусиенко", "Олефир", "Олефиренко", "Романенко", "Саенко", "Сасько", "Филь", "Франко", "Ющак",
			"Ющенко", "Юшко", "Яременко", "Ярема", "Фамилии", "Ведмидь", "Вовк", "Ворона", "Гоголь", "Горобець",
			"Зозуля", "Лелека", "Пацюк", "Перепелица", "Сорока", "Кобец", "Щур", "Белоштан", "Голопуп", "Голопупенко",
			"Дироштан", "Добривечир", "Жовтонис", "Каливод", ";Красношапка", "Кривонис", "Криворук", "Нетудыхата",
			"Сыволап", "Синебрюх", "Староконь", "Чорнопуп", "Дерипаска", "Затулывитер", "Крутыхвист", "Незовыбатько",
			"Нейижпапа", "Непыйвода", "Несвятыпаска", "Палывода", "Перебыйнис", "Пидопрыгора", "Попсуйшапка",
			"Тягныбок", "Тягнырядно", "Убыйбатька", "Белоконь", "Желтоконь", "Красноконь", "Рудоконь", "Рябоконь",
			"Сероконь", "Сивоконь", "Сизоконь", "Черноконь", "Беловол", "Красновол", "Рябовол", "Серовол", "Черновол",
			"Беловолк", "Сероволк", "Черноволк", "Белокоз", "Рябокоз", "Серокоз", "Сизокоз", "Чернокоз", "Чернопёс",
			"Рябокот", "Чернокот", "Рябокур", "Белощук", "Белокрыс", "Белокрысенко", "Серомыш", "Краснолис", "Черножук",
			"Беловошь", "Чернопчёл", "Черномух" };

	private final String[] firstFemaleNames = { "Агафья", "Агриппина", "Акулина", "Алевтина", "Александра", "Алина",
			"Алла", "Анастасия", "Ангелина", "Анжела", "Анжелика", "Анна", "Антонина", "Валентина", "Валерия",
			"Варвара", "Василиса", "Вера", "Вероника", "Виктория", "Галина", "Глафира", "Дана", "Дарья", "Евгения",
			"Евдокия", "Евпраксия", "Евфросиния", "Екатерина", "Елена", "Елизавета", "Ермиония", "Жанна", "Зинаида",
			"Злата", "Зоя", "Инга", "Инесса", "Инна", "Иоанна", "Ираида", "Ирина", "Ия", "Карина", "Каролина", "Кира",
			"Клавдия", "Ксения", "Лада", "Лариса", "Лидия", "Лилия", "Любовь", "Людмила", "Маргарита", "Марина",
			"Мария", "Марфа", "Матрёна", "Мирослава", "Надежда", "Наталья", "Нина", "Нонна", "Оксана", "Октябрина",
			"Ольга", "Пелагея", "Пинна", "Полина", "Прасковья", "Раиса", "Регина", "Римма", "Светлана", "Серафима",
			"Снежана", "София", "Таисия", "Тамара", "Татьяна", "Ульяна", "Фаина", "Феврония", "Фёкла", "Феодора",
			"Целестина", "Юлия", "Яна", "Ярослава" };
	private Random random = new Random();

	@Override
	public Author generate() {
		Author author = null;
		if (random.nextInt(20) % 2 == 0) {
			author = new Author(firstNames[random.nextInt(firstNames.length - 1)],
					lastNames[random.nextInt(lastNames.length - 1)]);
		} else {
			author = new Author(firstFemaleNames[random.nextInt(firstFemaleNames.length - 1)],
					lastNames[random.nextInt(lastNames.length - 1)]);
		}
		return author;
	}

}
