import images from '@/constants/images';
import React from 'react';
import { Image } from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import globalStyles from '../../constants/style';
import RegestrationBlock from '@/components/RegestrationBlock';
import Welcome from '@/components/Welcome';
import { Redirect, router } from 'expo-router';
import Enter from '@/components/Enter';
import Regestration from '@/components/Regestration';
import Parametrs from '@/components/Parametrs';
import Calendar from '@/components/SVG/Calendar';

export default function SignUp() {

  return (
    <SafeAreaView style={globalStyles.SAW}>
      <Image style={globalStyles.ImageBGRegestration}
        source={images.endStrong}
        resizeMode='cover'
      >
      </Image>
      <RegestrationBlock
        isReg = {true}
        childComponent= {<Regestration/>}
        title = 'Регестрация'
      />
    </SafeAreaView>
  );
}