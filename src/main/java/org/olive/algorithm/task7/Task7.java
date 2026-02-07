package org.olive.algorithm.task7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Task7.
 *
 * @author Elena Maltseva
 */
public class Task7 {

    private static class Node {
        // Дети для английских букв 'a'..'z'
        Node[] children = new Node[26];
        // Флаг, отмечающий, что до этого узла заканчивается слово
        boolean isWord = false;
    }

    private final Node node = new Node();


    /**
     * Проверяет, содержится ли точно такое слово в дереве.
     * Возвращает true только если найденное слово помечено как завершённое.
     */
    public boolean search(String word) {
        if (word == null) return false;
        Node node = nodeForPrefix(word);
        return node != null && node.isWord;
    }

    /**
     * Возвращает все слова, которые начинаются с данного префикса.
     * Если ни одного — возвращает пустой список.
     */
    public List<String> startWith(String prefix) {
        List<String> result = new ArrayList<>();
        if (prefix == null) return result;
        Node node = nodeForPrefix(prefix);
        if (node == null) {
            return result;
        }
        // Собираем все слова в поддереве node.
        StringBuilder sb = new StringBuilder(prefix);
        collectAllWords(node, sb, result);
        return result;
    }

    /**
     * Вставляет слово в префиксное дерево.
     */
    public void insert(String word) {
        if (word == null) throw new IllegalArgumentException("word == null");
        Node current = node;
        // Проходим по всем символам, создавая узлы при необходимости
        for (int k = 0; k < word.length(); k++) {
            char ch = word.charAt(k);
            int idx = indexOfChar(ch);
            if (current.children[idx] == null) {
                current.children[idx] = new Node();
            }
            current = current.children[idx];
        }
        // Помечаем конечный узел как слово
        current.isWord = true;
    }

    /**
     * Находит узел, соответствующий последнему символу префикса.
     * Возвращает null, если префикса нет.
     */
    private Node nodeForPrefix(String prefix) {
        Node current = node;
        for (int k = 0; k < prefix.length(); k++) {
            char ch = prefix.charAt(k);
            int idx = indexOfChar(ch);
            if (current.children[idx] == null) {
                return null;
            }
            current = current.children[idx];
        }
        return current;
    }

    /**
     * Проверяем, что  ожидаемый символ в пределах от a до z
     * и возвращаем его индекс
     */
    private static int indexOfChar(char c) {
        if (c < 'a' || c > 'z') {
            throw new IllegalArgumentException("Поддерживаются только строчные латинские буквы a-z. Символ: " + c);
        }
        return c - 'a';
    }

    /**
     * Собирает все слова из поддерева node.
     */
    private void collectAllWords(Node node, StringBuilder sb, List<String> out) {
        // Если текущая вершина помечена как слово, добавляем результат
        if (node.isWord) {
            out.add(sb.toString());
        }
        // Проходим по всем возможным детям в алфавитном порядке
        for (int i = 0; i < 26; i++) {
            Node child = node.children[i];
            if (child != null) {
                // Добавляем символ в конец текущего слова
                sb.append((char) ('a' + i));
                // Рекурсивно собираем слова из дочернего поддерева
                collectAllWords(child, sb, out);
                // Откатываем добавление символа
                sb.setLength(sb.length() - 1);
            }
        }
    }
}
