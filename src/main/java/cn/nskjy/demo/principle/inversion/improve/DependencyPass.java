package cn.nskjy.demo.principle.inversion.improve;

public class DependencyPass {
    public static void main(String[] args) {
        new OpenOrClose().open(new ChangHong());
    }
}



interface ITv{
    void play();
}

class ChangHong implements ITv{

    @Override
    public void play() {
        System.out.println("长虹电视机打开");
    }
}

interface IOpenOrClose{
    void open(ITv iTv);
}

class OpenOrClose implements IOpenOrClose{

    @Override
    public void open(ITv iTv) {
        iTv.play();
    }
}
