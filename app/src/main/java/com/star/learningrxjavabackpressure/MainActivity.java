package com.star.learningrxjavabackpressure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "RxJava";

    private Subscription mSubscription;

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.request);

        mButton.setOnClickListener(v -> mSubscription.request(48));

//        Observable
//                .create((ObservableOnSubscribe<Integer>) emitter -> {
//
//                    for (int i = 0; ; i++) {
//                        Thread.sleep(100);
//
//                        Log.d(TAG, "发送了事件"+ i );
//                        emitter.onNext(i);
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "开始采用subscribe连接");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//
//                        try {
//                            Thread.sleep(5000);
//
//                            Log.d(TAG, "对Next事件" + integer + "作出响应");
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "对Error事件作出响应");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "对Complete事件作出响应");
//                    }
//                });
//
//        Flowable
//                .create((FlowableOnSubscribe<Integer>) emitter -> {
//                    Log.d(TAG, "发送事件 1");
//                    emitter.onNext(1);
//
//                    Log.d(TAG, "发送事件 2");
//                    emitter.onNext(2);
//
//                    Log.d(TAG, "发送事件 3");
//                    emitter.onNext(3);
//
//                    Log.d(TAG, "发送完成");
//                    emitter.onComplete();
//                }, BackpressureStrategy.ERROR)
//                .subscribe(new Subscriber<Integer>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        Log.d(TAG, "开始采用subscribe连接");
//
//                        s.request(Long.MAX_VALUE);
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "对Next事件" + integer + "作出响应");
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        Log.d(TAG, "对Error事件作出响应");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "对Complete事件作出响应");
//                    }
//                });
//
//        Flowable
//                .create((FlowableOnSubscribe<Integer>) emitter -> {
//                    Log.d(TAG, "发送事件 1");
//                    emitter.onNext(1);
//
//                    Log.d(TAG, "发送事件 2");
//                    emitter.onNext(2);
//
//                    Log.d(TAG, "发送事件 3");
//                    emitter.onNext(3);
//
//                    Log.d(TAG, "发送完成");
//                    emitter.onComplete();
//                }, BackpressureStrategy.ERROR)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<Integer>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        Log.d(TAG, "开始采用subscribe连接");
//
//                        s.request(2);
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "对Next事件" + integer + "作出响应");
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        Log.d(TAG, "对Error事件作出响应");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "对Complete事件作出响应");
//                    }
//                });
//
//        Flowable
//                .create((FlowableOnSubscribe<Integer>) emitter -> {
//                    Log.d(TAG, "发送事件 1");
//                    emitter.onNext(1);
//
//                    Log.d(TAG, "发送事件 2");
//                    emitter.onNext(2);
//
//                    Log.d(TAG, "发送事件 3");
//                    emitter.onNext(3);
//
//                    Log.d(TAG, "发送完成");
//                    emitter.onComplete();
//                }, BackpressureStrategy.ERROR)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<Integer>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        Log.d(TAG, "开始采用subscribe连接");
//
//                        mSubscription = s;
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "对Next事件" + integer + "作出响应");
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        Log.d(TAG, "对Error事件作出响应");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "对Complete事件作出响应");
//                    }
//                });
//
//        Flowable
//                .create((FlowableOnSubscribe<Integer>) emitter -> {
//
//                    for (int i = 1; i <= 129; i++) {
//                        Log.d(TAG, "发送事件 " + i);
//                        emitter.onNext(i);
//                    }
//
//                    Log.d(TAG, "发送完成");
//                    emitter.onComplete();
//                }, BackpressureStrategy.ERROR)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<Integer>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        Log.d(TAG, "开始采用subscribe连接");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "对Next事件" + integer + "作出响应");
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        Log.d(TAG, "对Error事件作出响应 " + t.toString());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "对Complete事件作出响应");
//                    }
//                });
//
//        Flowable
//                .create((FlowableOnSubscribe<Integer>) emitter -> {
//
//                    Log.d(TAG, "发送事件 1");
//                    emitter.onNext(1);
//
//                    Log.d(TAG, "发送事件 2");
//                    emitter.onNext(2);
//
//                    Log.d(TAG, "发送事件 3");
//                    emitter.onNext(3);
//
//                    Log.d(TAG, "发送完成");
//                    emitter.onComplete();
//                }, BackpressureStrategy.ERROR)
//                .subscribe(new Subscriber<Integer>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        Log.d(TAG, "开始采用subscribe连接");
//
//                        s.request(3);
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "对Next事件" + integer + "作出响应");
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        Log.d(TAG, "对Error事件作出响应");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "对Complete事件作出响应");
//                    }
//                });
//
//        Flowable
//                .create((FlowableOnSubscribe<Integer>) emitter -> {
//
//                    Log.d(TAG, "发送事件 1");
//                    emitter.onNext(1);
//
//                    Log.d(TAG, "发送事件 2");
//                    emitter.onNext(2);
//
//                    Log.d(TAG, "发送事件 3");
//                    emitter.onNext(3);
//
//                    Log.d(TAG, "发送事件 4");
//                    emitter.onNext(4);
//
//                    Log.d(TAG, "发送完成");
//                    emitter.onComplete();
//                }, BackpressureStrategy.ERROR)
//                .subscribe(new Subscriber<Integer>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        Log.d(TAG, "开始采用subscribe连接");
//
//                        s.request(3);
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "对Next事件" + integer + "作出响应");
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        Log.d(TAG, "对Error事件作出响应 " + t.toString());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "对Complete事件作出响应");
//                    }
//                });
//
//        Flowable
//                .create((FlowableOnSubscribe<Integer>) emitter -> {
//
//                    Log.d(TAG, "发送事件 1");
//                    emitter.onNext(1);
//
//                    Log.d(TAG, "发送事件 2");
//                    emitter.onNext(2);
//
//                    Log.d(TAG, "发送事件 3");
//                    emitter.onNext(3);
//
//                    Log.d(TAG, "发送事件 4");
//                    emitter.onNext(4);
//
//                    Log.d(TAG, "发送完成");
//                    emitter.onComplete();
//                }, BackpressureStrategy.ERROR)
//                .subscribe(new Subscriber<Integer>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        Log.d(TAG, "开始采用subscribe连接");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "对Next事件" + integer + "作出响应");
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        Log.d(TAG, "对Error事件作出响应 " + t.toString());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "对Complete事件作出响应");
//                    }
//                });
//
//        Flowable
//                .create((FlowableOnSubscribe<Integer>) emitter -> {
//
//                    Long n = emitter.requested();
//
//                    Log.d(TAG, "观察者可接收事件数: " + n);
//
//                    for (int i = 1; i <= n; i++) {
//                        Log.d(TAG, "发送事件 " + i);
//                        emitter.onNext(i);
//                    }
//
//                    Log.d(TAG, "发送完成");
//                    emitter.onComplete();
//                }, BackpressureStrategy.ERROR)
//                .subscribe(new Subscriber<Integer>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        Log.d(TAG, "开始采用subscribe连接");
//
//                        s.request(3);
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "对Next事件" + integer + "作出响应");
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        Log.d(TAG, "对Error事件作出响应 " + t.toString());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "对Complete事件作出响应");
//                    }
//                });
//
//        Flowable
//                .create((FlowableOnSubscribe<Integer>) emitter -> {
//
//                    Long n = emitter.requested();
//
//                    Log.d(TAG, "观察者可接收事件数: " + n);
//
//                    for (int i = 1; i <= n; i++) {
//                        Log.d(TAG, "发送事件 " + i);
//                        emitter.onNext(i);
//                    }
//
//                    Log.d(TAG, "发送完成");
//                    emitter.onComplete();
//                }, BackpressureStrategy.ERROR)
//                .subscribe(new Subscriber<Integer>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        Log.d(TAG, "开始采用subscribe连接");
//
//                        s.request(3);
//                        s.request(3);
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "对Next事件" + integer + "作出响应");
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        Log.d(TAG, "对Error事件作出响应 " + t.toString());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "对Complete事件作出响应");
//                    }
//                });
//
//        Flowable
//                .create((FlowableOnSubscribe<Integer>) emitter -> {
//
//                    Long n = emitter.requested();
//
//                    Log.d(TAG, "观察者可接收事件数量 = " + n);
//
//                    for (int i = 1; i <= n; i++) {
//                        Log.d(TAG, "发送事件 " + i);
//                        emitter.onNext(i);
//                        Log.d(TAG, "发送了事件 " + i + " 后, " +
//                                "还需要发送事件数量 = " + emitter.requested());
//                    }
//
//                    Log.d(TAG, "发送完成");
//                    emitter.onComplete();
//                }, BackpressureStrategy.ERROR)
//                .subscribe(new Subscriber<Integer>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        Log.d(TAG, "开始采用subscribe连接");
//
//                        s.request(3);
//                        s.request(3);
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "对Next事件" + integer + "作出响应");
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        Log.d(TAG, "对Error事件作出响应 " + t.toString());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "对Complete事件作出响应");
//                    }
//                });
//
//        Flowable
//                .create((FlowableOnSubscribe<Integer>) emitter -> {
//
//                    Long n = emitter.requested();
//
//                    Log.d(TAG, "观察者可接收事件数量 = " + n);
//
//                    for (int i = 1; i <= n + 1; i++) {
//                        Log.d(TAG, "发送事件 " + i);
//                        emitter.onNext(i);
//                        Log.d(TAG, "发送了事件 " + i + " 后, " +
//                                "还需要发送事件数量 = " + emitter.requested());
//                    }
//
//                    Log.d(TAG, "发送完成");
//                    emitter.onComplete();
//                }, BackpressureStrategy.ERROR)
//                .subscribe(new Subscriber<Integer>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        Log.d(TAG, "开始采用subscribe连接");
//
//                        s.request(3);
//                        s.request(3);
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "对Next事件" + integer + "作出响应");
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        Log.d(TAG, "对Error事件作出响应 " + t.toString());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "对Complete事件作出响应");
//                    }
//                });
//
//        Flowable
//                .create((FlowableOnSubscribe<Integer>) emitter -> {
//
//                    Long n = emitter.requested();
//
//                    Log.d(TAG, "观察者可接收事件数量 = " + n);
//                }, BackpressureStrategy.ERROR)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<Integer>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        Log.d(TAG, "开始采用subscribe连接");
//
//                        s.request(150);
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "对Next事件" + integer + "作出响应");
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        Log.d(TAG, "对Error事件作出响应 " + t.toString());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "对Complete事件作出响应");
//                    }
//                });
//
//        Flowable
//                .create((FlowableOnSubscribe<Integer>) emitter -> {
//
//                    Log.d(TAG, "观察者可接收事件数量 = " + emitter.requested());
//
//                    boolean canBeSent;
//
//                    for (int i = 1; i <= 500; i++) {
//
//                        canBeSent = true;
//
//                        while (emitter.requested() == 0) {
//
//                            if (canBeSent) {
//
//                                Log.d(TAG, "不再发送");
//
//                                canBeSent = false;
//                            }
//                        }
//
//                        Log.d(TAG, "发送事件 " + i);
//                        emitter.onNext(i);
//                        Log.d(TAG, "发送了事件 " + i + " 后, " +
//                                "还需要发送事件数量 = " + emitter.requested());
//                    }
//
//                }, BackpressureStrategy.ERROR)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<Integer>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        Log.d(TAG, "开始采用subscribe连接");
//
//                        mSubscription = s;
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "对Next事件" + integer + "作出响应");
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        Log.d(TAG, "对Error事件作出响应");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "对Complete事件作出响应");
//                    }
//                });
//
//        Flowable
//                .create((FlowableOnSubscribe<Integer>) emitter -> {
//
//                    for (int i = 1; i <= 129; i++) {
//                        Log.d(TAG, "发送事件 " + i);
//                        emitter.onNext(i);
//                    }
//
//                    Log.d(TAG, "发送完成");
//                    emitter.onComplete();
//                }, BackpressureStrategy.ERROR)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<Integer>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        Log.d(TAG, "开始采用subscribe连接");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "对Next事件" + integer + "作出响应");
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        Log.d(TAG, "对Error事件作出响应 " + t.toString());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "对Complete事件作出响应");
//                    }
//                });
//
//        Flowable
//                .create((FlowableOnSubscribe<Integer>) emitter -> {
//
//                    for (int i = 1; i <= 129; i++) {
//                        Log.d(TAG, "发送事件 " + i);
//                        emitter.onNext(i);
//                    }
//
//                    Log.d(TAG, "发送完成");
//                    emitter.onComplete();
//                }, BackpressureStrategy.MISSING)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<Integer>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        Log.d(TAG, "开始采用subscribe连接");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "对Next事件" + integer + "作出响应");
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        Log.d(TAG, "对Error事件作出响应 " + t.toString());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "对Complete事件作出响应");
//                    }
//                });
//
//        Flowable
//                .create((FlowableOnSubscribe<Integer>) emitter -> {
//
//                    for (int i = 1; i <= 129; i++) {
//                        Log.d(TAG, "发送事件 " + i);
//                        emitter.onNext(i);
//                    }
//
//                    Log.d(TAG, "发送完成");
//                    emitter.onComplete();
//                }, BackpressureStrategy.BUFFER)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<Integer>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        Log.d(TAG, "开始采用subscribe连接");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "对Next事件" + integer + "作出响应");
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        Log.d(TAG, "对Error事件作出响应 " + t.toString());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "对Complete事件作出响应");
//                    }
//                });
//
//        Flowable
//                .create((FlowableOnSubscribe<Integer>) emitter -> {
//
//                    for (int i = 1; i <= 150; i++) {
//                        Log.d(TAG, "发送事件 " + i);
//                        emitter.onNext(i);
//                    }
//
//                    Log.d(TAG, "发送完成");
//                    emitter.onComplete();
//                }, BackpressureStrategy.DROP)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<Integer>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        Log.d(TAG, "开始采用subscribe连接");
//
//                        mSubscription = s;
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "对Next事件" + integer + "作出响应");
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        Log.d(TAG, "对Error事件作出响应 " + t.toString());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "对Complete事件作出响应");
//                    }
//                });
//
//        Flowable
//                .create((FlowableOnSubscribe<Integer>) emitter -> {
//
//                    for (int i = 1; i <= 150; i++) {
//                        Log.d(TAG, "发送事件 " + i);
//                        emitter.onNext(i);
//                    }
//
//                    Log.d(TAG, "发送完成");
//                    emitter.onComplete();
//                }, BackpressureStrategy.LATEST)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<Integer>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        Log.d(TAG, "开始采用subscribe连接");
//
//                        mSubscription = s;
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "对Next事件" + integer + "作出响应");
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        Log.d(TAG, "对Error事件作出响应 " + t.toString());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "对Complete事件作出响应");
//                    }
//                });

        Flowable
                .interval(1, TimeUnit.MILLISECONDS)
                .onBackpressureBuffer()
                .observeOn(Schedulers.newThread())
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        Log.d(TAG, "开始采用subscribe连接");

                        mSubscription = s;

                        s.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.d(TAG, "对Next事件" + aLong + "作出响应");

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.d(TAG, "对Error事件作出响应 " + t.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "对Complete事件作出响应");
                    }
                });
    }
}
