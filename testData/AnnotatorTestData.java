public class AnnotatorTestData {

  void fun() {

    // round brackets ((((6))))
    int i = (<info descr="null">(</info><info descr="null">(</info><info descr="null">(</info>6<info descr="null">)</info><info descr="null">)</info><info descr="null">)</info>);

    // angled brackets List<List<List<List<String>>>>
    List<List<info descr="null"><</info>List<info descr="null"><</info>List<info descr="null"><</info><error descr="Cannot resolve symbol 'String'">String</error><info descr="null">></info><info descr="null">></info><info descr="null">></info>> list;

    // should be no nested angled brackets detected
    if (3<4) if (4<5);

  }

}