# AGENTS.md

## Repo overview

- **Purpose**: Learning project — study Java concepts one at a time, saved in git.
- **Stack**: Plain Java — no Maven/Gradle. Compile with `javac`, run with `java`.
- **JDK**: GraalVM JDK 21 (set in `.idea/misc.xml`). Use Java 21 features.
- **No CI, no tests, no linter/formatter**.
- **No commits yet** — branch `main` is empty.

## Source layout

```
src/<concept-dir>/    ← source files for a topic
out/<concept-dir>/    ← compiled .class files (IntelliJ output)
```

- Source file naming: `<ClassName>.java`, class name matches the directory topic.
- Package = concept directory name (e.g. `slidingwindow`, `multithreading`).
- **Note**: `src/slidingwindow/` has no `.java` files yet — only compiled `.class` files from a prior session exist in `out/slidingwindow/`.
- **Note**: `src/multithreading/Example_1.java` declares class `Example` (not `Example_1`) — watch for file/class name mismatches.

## Owner weak areas (tailor explanations)

1. REST API design principles
2. Sliding window & circular array problems (LC 918, 643, 239, 560)
3. HashMap / cache-based problems (LC 146, 1, 49, 706)
4. SQL — GROUP BY, HAVING, JOINs, aggregates
5. Java fundamentals — primitives, types, collections
6. Java Threads — concurrency, synchronized, volatile, wait/notify, executors
7. Java Streams API — map/filter/reduce, collectors, parallel streams

## Agent behaviour

- **Hint first, solution second** — never jump straight to code unless asked.
- **Always provide** a dry-run trace on the example input + Big-O time/space.
- **Always surface edge cases**: circular arrays, overflow (`long`), empty inputs.
- **Java 21** by default. Ask before switching languages.
- **For theory questions** (REST, Java types, SQL): direct answer → 2–3 sentence reasoning → counter-example for MCQs.

## Gotchas

- `int` overflow: use `long` when values can exceed ~2.1B.
- SQL: `WHERE` filters rows → `GROUP BY` groups → `HAVING` filters groups. Never put aggregate conditions in `WHERE`.
- MySQL `ONLY_FULL_GROUP_BY`: every SELECT column must be in GROUP BY or wrapped in an aggregate.
- REST has no built-in security; always use HTTPS in practice.
- 8 Java primitives: `byte`, `short`, `int`, `long`, `float`, `double`, `char`, `boolean`. `String` is a class.
- Prefer `List<Integer>` over `int[]` for HackerRank-style flexibility.
