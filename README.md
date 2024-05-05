# Пример приложения JavaFX

## О репозитории

В данном репозитории содержится проект примера написания десктопных приложений с использованием чистой архитектуры на языке Java (ну, почти чистой архитектуры :)

В процессе множественной разработки было принято решение собрать некоторые модули воедино для дальнейшего использования (например, абстрактный модуль контроллера, анимация, модуль исполнителя, обработчиков ошибок и прочего). 

## Использование менеджера контроллеров

Для простоты переключения между разными контроллерами было принято решение создать абстрактный класс контроллера, а также класс менеджера контроллеров, который является экземпляром списка контроллеров с дополнительными методами.

## Использование исполнителя как входной точки в Usecase/Interactor

Использование исполнителя как входной точки в бизнес-логику помогает решить проблему множественной обработки ошибок, сосредотачивает логирование и облегчает обработку исключений. Для обработки оповещений возможно использование кастомного Presenter через интерфейс, а также обычный возврат.

## Использование и улучшение
Если вы нашли какие-то неточности или возможности улучшить программный код, пожалуйста, опишите свое мнение в issues и/или составьте pull-request с исправлениями. Буду рад любому конструктивному участию! 