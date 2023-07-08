package com.example.fanp.di.module;


import com.example.fanp.domain.local.data.I4AllSettingDao;
import com.example.fanp.presentation.modbus.GrpcModBus;
import com.example.fanp.presentation.s7.S7Grpc;

import java.io.IOException;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@Module
public class GrpcModule {

    String host =  "192.168.0.205";
    int portStr = 50051;

    @Inject
    public GrpcModule(){}

    @Provides
    public ManagedChannel providerManagedChannel(){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, portStr).usePlaintext().build();
        return channel;
    }


    @Provides
    public GrpcModBus providgrpcmodbus(ManagedChannel channel, I4AllSettingDao db){
        GrpcModBus grpcModBus = new GrpcModBus(channel,db);
        return grpcModBus;
    }


    @Provides
    public S7Grpc providS7Grpc(ManagedChannel channel, I4AllSettingDao db){
        S7Grpc s7Grpc = new S7Grpc(channel,db);
        return s7Grpc;
    }



    public boolean isConnected(){
        System.out.println("executeCommand");
        Runtime runtime = Runtime.getRuntime();
        try
        {
            Process  mIpAddrProcess = runtime.exec("/system/bin/ifconfig eth1 192.168.0.250 netmask 255.255.255.0");
            int mExitValue = mIpAddrProcess.waitFor();
            System.out.println(" mExitValue "+mExitValue);
            if(mExitValue==0){
                return true;
            }else{
                return false;
            }
        }
        catch (InterruptedException | IOException sfv)
        {
            sfv.printStackTrace();
            System.out.println(" Exception:"+sfv);
        }
        return false;
    }

}
